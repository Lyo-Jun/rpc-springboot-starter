package leo.rpc.client.net;

import leo.rpc.common.model.Service;
import leo.rpc.common.protocol.MessageProtocol;
import leo.rpc.common.model.RpcRequest;
import leo.rpc.common.model.RpcResponse;

/**
 *
 * 网络请求客户端，定义请求规范
 *
 */
public interface NetClient {

    byte[] sendRequest(byte[] data, Service service) throws InterruptedException;

    RpcResponse sendRequest(RpcRequest rpcRequest, Service service, MessageProtocol messageProtocol);
}
