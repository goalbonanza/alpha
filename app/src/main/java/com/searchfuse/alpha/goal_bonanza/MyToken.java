package com.searchfuse.alpha.goal_bonanza;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicBytes;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.3.1.
 */
public final class MyToken extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516109e23803806109e2833981016040528080519190602001805182019190602001805191906020018051600160a060020a0333166000908152600460205260408120879055600387905592019190508380516100729291602001906100a4565b5060018180516100869291602001906100a4565b50506002805460ff191660ff929092169190911790555061013f9050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100e557805160ff1916838001178555610112565b82800160010185558215610112579182015b828111156101125782518255916020019190600101906100f7565b5061011e929150610122565b5090565b61013c91905b8082111561011e5760008155600101610128565b90565b6108948061014e6000396000f300606060405236156100b75763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306fdde0381146100bc578063095ea7b31461014657806318160ddd1461017c57806323b872dd146101a1578063313ce567146101c957806342966c68146101f257806370a082311461020857806379cc67901461022757806395d89b4114610249578063a9059cbb1461025c578063cae9ca5114610280578063dd62ed3e146102e5575b600080fd5b34156100c757600080fd5b6100cf61030a565b60405160208082528190810183818151815260200191508051906020019080838360005b8381101561010b5780820151838201526020016100f3565b50505050905090810190601f1680156101385780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561015157600080fd5b610168600160a060020a03600435166024356103a8565b604051901515815260200160405180910390f35b341561018757600080fd5b61018f6103d8565b60405190815260200160405180910390f35b34156101ac57600080fd5b610168600160a060020a03600435811690602435166044356103de565b34156101d457600080fd5b6101dc610454565b60405160ff909116815260200160405180910390f35b34156101fd57600080fd5b61016860043561045d565b341561021357600080fd5b61018f600160a060020a03600435166104e7565b341561023257600080fd5b610168600160a060020a03600435166024356104f9565b341561025457600080fd5b6100cf6105d5565b341561026757600080fd5b61027e600160a060020a0360043516602435610640565b005b341561028b57600080fd5b61016860048035600160a060020a03169060248035919060649060443590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284375094965061064f95505050505050565b34156102f057600080fd5b61018f600160a060020a0360043581169060243516610781565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103a05780601f10610375576101008083540402835291602001916103a0565b820191906000526020600020905b81548152906001019060200180831161038357829003601f168201915b505050505081565b600160a060020a033381166000908152600560209081526040808320938616835292905220819055600192915050565b60035481565b600160a060020a03808416600090815260056020908152604080832033909416835292905290812054821061041257600080fd5b600160a060020a038085166000908152600560209081526040808320339094168352929052208054839003905561044a84848461079e565b5060019392505050565b60025460ff1681565b600160a060020a03331660009081526004602052604081205482901161048257600080fd5b600160a060020a03331660008181526004602052604090819020805485900390556003805485900390557fcc16f5dbb4873280815c1ee09dbd06736cffcc184412cf7a71a0fdb75d397ca59084905190815260200160405180910390a2506001919050565b60046020526000908152604090205481565b600160a060020a0382166000908152600460205260408120548290101561051f57600080fd5b600160a060020a038084166000908152600560209081526040808320339094168352929052205482111561055257600080fd5b600160a060020a038084166000818152600460209081526040808320805488900390556005825280832033909516835293905282902080548590039055600380548590039055907fcc16f5dbb4873280815c1ee09dbd06736cffcc184412cf7a71a0fdb75d397ca59084905190815260200160405180910390a250600192915050565b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103a05780601f10610375576101008083540402835291602001916103a0565b61064b33838361079e565b5050565b60008361065c81856103a8565b156107795780600160a060020a0316638f4ffcb1338630876040518563ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018085600160a060020a0316600160a060020a0316815260200184815260200183600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b838110156107125780820151838201526020016106fa565b50505050905090810190601f16801561073f5780820380516001836020036101000a031916815260200191505b5095505050505050600060405180830381600087803b151561076057600080fd5b6102c65a03f1151561077157600080fd5b505050600191505b509392505050565b600560209081526000928352604080842090915290825290205481565b600160a060020a03821615156107b357600080fd5b600160a060020a0383166000908152600460205260409020548190116107d857600080fd5b600160a060020a038216600090815260046020526040902054818101116107fe57600080fd5b600160a060020a038084166000818152600460205260408082208054869003905592851680825290839020805485019055917fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef9084905190815260200160405180910390a35050505600a165627a7a72305820a038dbb7957594922c9d43c8f668a0fdf05f4e1469c6ad5c54975ff520715eee0029";

    private MyToken(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private MyToken(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.from = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.to = (Address) eventValues.getIndexedValues().get(1);
            typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.from = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.to = (Address) eventValues.getIndexedValues().get(1);
                typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<BurnEventResponse> getBurnEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Burn", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<BurnEventResponse> responses = new ArrayList<BurnEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            BurnEventResponse typedResponse = new BurnEventResponse();
            typedResponse.from = (Address) eventValues.getIndexedValues().get(0);
            typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<BurnEventResponse> burnEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Burn", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, BurnEventResponse>() {
            @Override
            public BurnEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                BurnEventResponse typedResponse = new BurnEventResponse();
                typedResponse.from = (Address) eventValues.getIndexedValues().get(0);
                typedResponse.value = (Uint256) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<Utf8String> name() {
        Function function = new Function("name", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> approve(Address _spender, Uint256 _value) {
        Function function = new Function("approve", Arrays.<Type>asList(_spender, _value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> totalSupply() {
        Function function = new Function("totalSupply", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> transferFrom(Address _from, Address _to, Uint256 _value) {
        Function function = new Function("transferFrom", Arrays.<Type>asList(_from, _to, _value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint8> decimals() {
        Function function = new Function("decimals", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> burn(Uint256 _value) {
        Function function = new Function("burn", Arrays.<Type>asList(_value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> balanceOf(Address param0) {
        Function function = new Function("balanceOf", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> burnFrom(Address _from, Uint256 _value) {
        Function function = new Function("burnFrom", Arrays.<Type>asList(_from, _value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Utf8String> symbol() {
        Function function = new Function("symbol", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> transfer(Address _to, Uint256 _value) {
        Function function = new Function("transfer", Arrays.<Type>asList(_to, _value), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> approveAndCall(Address _spender, Uint256 _value, DynamicBytes _extraData) {
        Function function = new Function("approveAndCall", Arrays.<Type>asList(_spender, _value, _extraData), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> allowance(Address param0, Address param1) {
        Function function = new Function("allowance", 
                Arrays.<Type>asList(param0, param1), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<MyToken> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 initialSupply, Utf8String tokenName, Uint8 decimalUnits, Utf8String tokenSymbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(initialSupply, tokenName, decimalUnits, tokenSymbol));
        return deployAsync(MyToken.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static Future<MyToken> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, Uint256 initialSupply, Utf8String tokenName, Uint8 decimalUnits, Utf8String tokenSymbol) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(initialSupply, tokenName, decimalUnits, tokenSymbol));
        return deployAsync(MyToken.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static MyToken load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyToken(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static MyToken load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyToken(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class TransferEventResponse {
        public Address from;

        public Address to;

        public Uint256 value;
    }

    public static class BurnEventResponse {
        public Address from;

        public Uint256 value;
    }
}
