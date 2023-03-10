package leo.rpc.common.protocol;


import leo.rpc.annotation.MessageProtocolAno;
import leo.rpc.common.constants.RpcConstant;
import leo.rpc.common.model.RpcRequest;
import leo.rpc.common.model.RpcResponse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Java序列化消息协议
 */
@MessageProtocolAno(RpcConstant.PROTOCOL_JAVA)
public class JavaSerializeMessageProtocol implements MessageProtocol {

    private byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(o);
        return bout.toByteArray();

    }

    

    @Override
    public byte[] marshallingRequest(RpcRequest request) throws Exception {
        return this.serialize(request);
    }

    @Override
    public RpcRequest unmarshallingRequest(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (RpcRequest) in.readObject();
    }

    @Override
    public byte[] marshallingResponse(RpcResponse response) throws Exception {
        return this.serialize(response);
    }

    @Override
    public RpcResponse unmarshallingResponse(byte[] data) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data));
        return (RpcResponse) in.readObject();
    }
}
