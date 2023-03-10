package leo.rpc.client.discovery;

import leo.rpc.common.model.Service;

import java.util.List;

/**
 *
 * 服务发现抽象类
 */
public interface ServerDiscovery {

    List<Service> findServiceList(String name);
}
