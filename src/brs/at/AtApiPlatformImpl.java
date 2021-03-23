package brs.at;

import brs.Appendix;
import brs.Burst;
import brs.Transaction;
import brs.Attachment.ColoredCoinsAssetTransfer;
import brs.crypto.Crypto;
import brs.fluxcapacitor.FluxValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Arrays;

public class AtApiPlatformImpl extends AtApiImpl {

    private static final Logger logger = LoggerFactory.getLogger(AtApiPlatformImpl.class);

    private static final AtApiPlatformImpl instance = new AtApiPlatformImpl();


    private AtApiPlatformImpl() {
    }

    public static AtApiPlatformImpl getInstance() {
        return instance;
    }

    private static Long findTransaction(int startHeight, int endHeight, Long atID, int numOfTx, long minAmount) {
        return Burst.getStores().getAtStore().findTransaction(startHeight, endHeight, atID, numOfTx, minAmount);
    }

    private static int findTransactionHeight(Long transactionId, int height, Long atID, long minAmount) {
        return Burst.getStores().getAtStore().findTransactionHeight(transactionId, height, atID, minAmount);
    }

    @Override
    public long getBlockTimestamp(AtMachineState state) {
        int height = state.getHeight();
        return AtApiHelper.getLongTimestamp(height, 0);
    }

    @Override
    public long getCreationTimestamp(AtMachineState state) {
        return AtApiHelper.getLongTimestamp(state.getCreationBlockHeight(), 0);
    }

    @Override
    public long getLastBlockTimestamp(AtMachineState state) {
        int height = state.getHeight() - 1;
        return AtApiHelper.getLongTimestamp(height, 0);
    }

    @Override
    public void putLastBlockHashInA(AtMachineState state) {
        ByteBuffer b = ByteBuffer.allocate(state.getA1().length * 4);
        b.order(ByteOrder.LITTLE_ENDIAN);

        b.put(Burst.getBlockchain().getBlockAtHeight(state.getHeight() - 1).getBlockHash());

        b.clear();

        byte[] temp = new byte[8];

        b.get(temp, 0, 8);
        state.setA1(temp);

        b.get(temp, 0, 8);
        state.setA2(temp);

        b.get(temp, 0, 8);
        state.setA3(temp);

        b.get(temp, 0, 8);
        state.setA4(temp);
    }

    @Override
    public void aToTxAfterTimestamp(long val, AtMachineState state) {

        int height = AtApiHelper.longToHeight(val);
        int numOfTx = AtApiHelper.longToNumOfTx(val);

        byte[] b = state.getId();

        long tx = findTransaction(height, state.getHeight(), AtApiHelper.getLong(b), numOfTx, state.minActivationAmount());
        logger.debug("tx with id {} found", tx);
        clearA(state);
        state.setA1(AtApiHelper.getByteArray(tx));

    }

    @Override
    public long getTypeForTxInA(AtMachineState state) {
        long txid = AtApiHelper.getLong(state.getA1());

        Transaction tx = Burst.getBlockchain().getTransaction(txid);

        if (tx == null || (tx.getHeight() >= state.getHeight())) {
            return -1;
        }

        if (tx.getMessage() != null) {
            return 1;
        }

        ColoredCoinsAssetTransfer attachment = (tx.getAttachment() instanceof ColoredCoinsAssetTransfer)?(ColoredCoinsAssetTransfer)tx.getAttachment():null;
        if (attachment != null) {
            return 2;
        }

        return 0;
    }

    @Override
    public long getAmountForTxInA(AtMachineState state) {
        long txId = AtApiHelper.getLong(state.getA1());

        Transaction tx = Burst.getBlockchain().getTransaction(txId);

        if (tx == null || (tx.getHeight() >= state.getHeight())) {
            return -1;
        }

        if ((tx.getMessage() == null || Burst.getFluxCapacitor().getValue(FluxValues.AT_FIX_BLOCK_2, state.getHeight())) && state.minActivationAmount() <= tx.getAmountNQT()) {
            return tx.getAmountNQT() - state.minActivationAmount();
        }

        return 0;
    }

    @Override
    public long getAssetIdForTxInA(AtMachineState state) {
        long txId = AtApiHelper.getLong(state.getA1());

        Transaction tx = Burst.getBlockchain().getTransaction(txId);

        if (tx == null || tx.getHeight() >= state.getHeight() || AtConstants.getInstance().supportAssetsEnabled(state.getHeight()) ) {
            return -1;
        }

        ColoredCoinsAssetTransfer attachment = (tx.getAttachment() instanceof ColoredCoinsAssetTransfer)?(ColoredCoinsAssetTransfer)tx.getAttachment():null;
        if (attachment != null) {
            return attachment.getAssetId();
        }

        return -1;
    }

    @Override
    public long getAssetAmountForTxInA(AtMachineState state) {
        long txId = AtApiHelper.getLong(state.getA1());

        Transaction tx = Burst.getBlockchain().getTransaction(txId);

        if (tx == null || tx.getHeight() >= state.getHeight() || AtConstants.getInstance().supportAssetsEnabled(state.getHeight())) {
            return -1;
        }

        ColoredCoinsAssetTransfer attachment = (tx.getAttachment() instanceof ColoredCoinsAssetTransfer)?(ColoredCoinsAssetTransfer)tx.getAttachment():null;
        if (attachment != null) {
            return attachment.getQuantityQNT();
        }

        return 0;
    }

    @Override
    public long mold(AtMachineState state) {

        if(AtConstants.getInstance().supportAssetsEnabled(state.getHeight())) {
            state.setA1(AtApiHelper.getByteArray(-1));
            return -1;
        }

        //if Mold is done successfully set A to the asset id, asset information in  B1(assetDecimals) B2(assetQuantity) A1~4(assetDesc) B3-4(assetName)

        //asset name in B3 and B4
        ByteBuffer bName = ByteBuffer.allocate(16);
        bName.order(ByteOrder.LITTLE_ENDIAN);
        bName.put(state.getB3());
        bName.put(state.getB4());
        bName.clear(); 

        //asset description in A1 ~ A4
        ByteBuffer bDesc = ByteBuffer.allocate(32);
        bDesc.order(ByteOrder.LITTLE_ENDIAN);
        bDesc.put(state.getA1());
        bDesc.put(state.getA2());
        bDesc.put(state.getA3());
        bDesc.put(state.getA4());
        bDesc.clear();

        //asset quantity QNT in B2
        long quantityQNT = AtApiHelper.getLong(state.getB2());

        //asset decimals in B1
        long decimals = AtApiHelper.getLong(state.getB1());

        int height = state.getHeight();


        AtTransaction tx = new AtTransaction(state.getId(), AtApiHelper.getByteArray(0L), 0L,bName.array());
        long assetState = tx.setAsset(bName.array(), bDesc.array(), quantityQNT, (byte)decimals, height);
        if(assetState < 0){
            state.setA1(AtApiHelper.getByteArray(assetState));
            return assetState;
        }
        
        state.setA1(AtApiHelper.getByteArray(tx.getAssetId()));
        
        state.addTransaction(tx);
        
        return tx.getAssetId();
    }

    @Override
    public long mint(AtMachineState state) {

        if(AtConstants.getInstance().supportAssetsEnabled(state.getHeight())) {
            return 0;
        }

        //if B1 is a valid address then send it the amount, asset and msg.  B1(address) B2(asset amount) A1~4(message) B3(asset id) B4(amount)

        //burstcoin amount QNT in B4
        long amountQNT = AtApiHelper.getLong(state.getB4());

        //message in A1 ~ A4
        ByteBuffer bMsg = ByteBuffer.allocate(32);
        bMsg.order(ByteOrder.LITTLE_ENDIAN);
        bMsg.put(state.getA1());
        bMsg.put(state.getA2());
        bMsg.put(state.getA3());
        bMsg.put(state.getA4());
        bMsg.clear();

        //asset id in B3
        long assetId = AtApiHelper.getLong(state.getB3());

        //asset amount QNT in B2
        long assetAmountQNT = AtApiHelper.getLong(state.getB2());

        AtTransaction tx = new AtTransaction(state.getId(), state.getB1().clone(), amountQNT, bMsg.array());
        tx.setAssetId(assetId);
        tx.setAssetAmount(assetAmountQNT);
        state.addTransaction(tx);
       

        return 0;
        
    }
 
    @Override
    public long getTimestampForTxInA(AtMachineState state) {
        long txId = AtApiHelper.getLong(state.getA1());
        logger.debug("get timestamp for tx with id {} found", txId);
        Transaction tx = Burst.getBlockchain().getTransaction(txId);

        if (tx == null || (tx.getHeight() >= state.getHeight())) {
            return -1;
        }

        byte[] b = state.getId();
        int blockHeight = tx.getHeight();
        int txHeight = findTransactionHeight(txId, blockHeight, AtApiHelper.getLong(b), state.minActivationAmount());

        return AtApiHelper.getLongTimestamp(blockHeight, txHeight);
    }

    @Override
    public long getRandomIdForTxInA(AtMachineState state) {
        long txId = AtApiHelper.getLong(state.getA1());

        Transaction tx = Burst.getBlockchain().getTransaction(txId);

        if (tx == null || (tx.getHeight() >= state.getHeight())) {
            return -1;
        }

        int txBlockHeight = tx.getHeight();
        int blockHeight = state.getHeight();

        if (blockHeight - txBlockHeight < AtConstants.getInstance().blocksForRandom(blockHeight)) { //for tests - for real case 1440
            state.setWaitForNumberOfBlocks((int) AtConstants.getInstance().blocksForRandom(blockHeight) - (blockHeight - txBlockHeight));
            state.getMachineState().pc -= 7;
            state.getMachineState().stopped = true;
            return 0;
        }

        MessageDigest digest = Crypto.sha256();

        byte[] senderPublicKey = tx.getSenderPublicKey();

        ByteBuffer bf = ByteBuffer.allocate((Burst.getFluxCapacitor().getValue(FluxValues.SODIUM)) ?
        		32 + 8 + senderPublicKey.length :
        		32 + Long.SIZE + senderPublicKey.length);
        bf.order(ByteOrder.LITTLE_ENDIAN);
        bf.put(Burst.getBlockchain().getBlockAtHeight(blockHeight - 1).getGenerationSignature());
        bf.putLong(tx.getId());
        bf.put(senderPublicKey);

        digest.update(bf.array());
        byte[] byteRandom = digest.digest();

        return Math.abs(AtApiHelper.getLong(Arrays.copyOfRange(byteRandom, 0, 8)));
    }

    @Override
    public void messageFromTxInAToB(AtMachineState state) {
        long txid = AtApiHelper.getLong(state.getA1());

        Transaction tx = Burst.getBlockchain().getTransaction(txid);
        if (tx != null && tx.getHeight() >= state.getHeight()) {
            tx = null;
        }

        ByteBuffer b = ByteBuffer.allocate(state.getA1().length * 4);
        b.order(ByteOrder.LITTLE_ENDIAN);
        if (tx != null) {
            Appendix.Message txMessage = tx.getMessage();
            if (txMessage != null) {
                byte[] message = txMessage.getMessageBytes();
                if (message.length <= state.getA1().length * 4) {
                    b.put(message);
                }
            }
        }

        b.clear();

        byte[] temp = new byte[8];

        b.get(temp, 0, 8);
        state.setB1(temp);

        b.get(temp, 0, 8);
        state.setB2(temp);

        b.get(temp, 0, 8);
        state.setB3(temp);

        b.get(temp, 0, 8);
        state.setB4(temp);

    }

    @Override
    public void bToAddressOfTxInA(AtMachineState state) {
        long txId = AtApiHelper.getLong(state.getA1());

        clearB(state);

        Transaction tx = Burst.getBlockchain().getTransaction(txId);
        if (tx != null && tx.getHeight() >= state.getHeight()) {
            tx = null;
        }
        if (tx != null) {
            long address = tx.getSenderId();
            state.setB1(AtApiHelper.getByteArray(address));
        }
    }

    @Override
    public void bToAddressOfCreator(AtMachineState state) {
        long creator = AtApiHelper.getLong(state.getCreator());

        clearB(state);

        state.setB1(AtApiHelper.getByteArray(creator));

    }

    @Override
    public void putLastBlockGenerationSignatureInA(AtMachineState state) {
        ByteBuffer b = ByteBuffer.allocate(state.getA1().length * 4);
        b.order(ByteOrder.LITTLE_ENDIAN);

        b.put(Burst.getBlockchain().getBlockAtHeight(state.getHeight() - 1).getGenerationSignature());

        b.clear();

        byte[] temp = new byte[8];

        b.get(temp, 0, 8);
        state.setA1(temp);

        b.get(temp, 0, 8);
        state.setA2(temp);

        b.get(temp, 0, 8);
        state.setA3(temp);

        b.get(temp, 0, 8);
        state.setA4(temp);
    }

    @Override
    public long getCurrentBalance(AtMachineState state) {
        if (!Burst.getFluxCapacitor().getValue(FluxValues.AT_FIX_BLOCK_2, state.getHeight())) {
            return 0;
        }

        return state.getgBalance();
    }

    @Override
    public long getAssetMintableBalance(AtMachineState state) {

        if (!AtConstants.getInstance().supportAssetsEnabled(state.getHeight())) {
            return 0;
        }

        //asset id in B1
        long assetId = AtApiHelper.getLong(state.getB1());
        brs.Asset asset = Burst.getStores().getAssetStore().getAssetTable().getBy(brs.schema.Tables.ASSET.ID.eq(assetId));
        if(asset != null && asset.getAccountId() == AtApiHelper.getLong(state.getId()))
        {
            brs.Account.AccountAsset accountAsset = Burst.getStores().getAccountStore().getAccountAssetTable().getBy(brs.schema.Tables.ACCOUNT_ASSET.ACCOUNT_ID.eq(asset.getAccountId())
                                                                                                    .and(brs.schema.Tables.ACCOUNT_ASSET.ASSET_ID.eq(assetId)));
            if(accountAsset != null)
                return accountAsset.getQuantityQNT();
        }
        
        return 0;
    }

    @Override
    public long getPreviousBalance(AtMachineState state) {
        if (!Burst.getFluxCapacitor().getValue(FluxValues.AT_FIX_BLOCK_2, state.getHeight())) {
            return 0;
        }

        return state.getpBalance();
    }

    @Override
    public void sendToAddressInB(long val, AtMachineState state) {
        if (val < 1)
            return;

        if (val < state.getgBalance()) {
            AtTransaction tx = new AtTransaction(state.getId(), state.getB1().clone(), val, null);
            state.addTransaction(tx);

            state.setgBalance(state.getgBalance() - val);
        } else {
            AtTransaction tx = new AtTransaction(state.getId(), state.getB1().clone(), state.getgBalance(), null);
            state.addTransaction(tx);

            state.setgBalance(0L);
        }
    }

    @Override
    public void sendAllToAddressInB(AtMachineState state) {
        AtTransaction tx = new AtTransaction(state.getId(), state.getB1().clone(), state.getgBalance(), null);
        state.addTransaction(tx);
        state.setgBalance(0L);
    }

    @Override
    public void sendOldToAddressInB(AtMachineState state) {
        if (state.getpBalance() > state.getgBalance()) {
            AtTransaction tx = new AtTransaction(state.getId(), state.getB1(), state.getgBalance(), null);
            state.addTransaction(tx);

            state.setgBalance(0L);
            state.setpBalance(0L);
        } else {
            AtTransaction tx = new AtTransaction(state.getId(), state.getB1(), state.getpBalance(), null);
            state.addTransaction(tx);

            state.setgBalance(state.getgBalance() - state.getpBalance());
            state.setpBalance(0L);
        }
    }

    @Override
    public void sendAToAddressInB(AtMachineState state) {
        ByteBuffer b = ByteBuffer.allocate(32);
        b.order(ByteOrder.LITTLE_ENDIAN);
        b.put(state.getA1());
        b.put(state.getA2());
        b.put(state.getA3());
        b.put(state.getA4());
        b.clear();

        AtTransaction tx = new AtTransaction(state.getId(), state.getB1(), 0L, b.array());
        state.addTransaction(tx);
    }

    @Override
    public long addMinutesToTimestamp(long val1, long val2, AtMachineState state) {
        int height = AtApiHelper.longToHeight(val1);
        int numOfTx = AtApiHelper.longToNumOfTx(val1);
        int addHeight = height + (int) (val2 / AtConstants.getInstance().averageBlockMinutes(state.getHeight()));

        return AtApiHelper.getLongTimestamp(addHeight, numOfTx);
    }
}
