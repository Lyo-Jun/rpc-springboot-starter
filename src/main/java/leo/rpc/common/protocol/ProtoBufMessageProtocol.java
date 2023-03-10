package leo.rpc.common.protocol;

import leo.rpc.annotation.MessageProtocolAno;
import leo.rpc.common.constants.RpcConstant;
import leo.rpc.common.model.RpcRequest;
import leo.rpc.common.model.RpcResponse;
import leo.rpc.util.SerializingUtil;

/**
 * Protobuf序列化协议
 */
@MessageProtocolAno(RpcConstant.PROTOCOL_PROTOBUF)
public class ProtoBufMessageProtocol implements MessageProtocol{

    @Override
    public byte[] marshallingRequest(RpcRequest request) throws Exception {
        return SerializingUtil.serialize(request);
    }

    @Override
    public RpcRequest unmarshallingRequest(byte[] data) throws Exception {
        return SerializingUtil.deserialize(data,RpcRequest.class);
    }

    @Override
    public byte[] marshallingResponse(RpcResponse response) throws Exception {
        return SerializingUtil.serialize(response);
    }

    @Override
    public RpcResponse unmarshallingResponse(byte[] data) throws Exception {
        return SerializingUtil.deserialize(data,RpcResponse.class);
    }
}
