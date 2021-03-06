// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.vpc;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Local;
import javax.naming.ConfigurationException;

import com.cloud.acl.ControlledEntity.ACLType;
import com.cloud.api.commands.ListPrivateGatewaysCmd;
import com.cloud.api.commands.ListStaticRoutesCmd;
import com.cloud.exception.ConcurrentOperationException;
import com.cloud.exception.InsufficientAddressCapacityException;
import com.cloud.exception.InsufficientCapacityException;
import com.cloud.exception.NetworkRuleConflictException;
import com.cloud.exception.ResourceAllocationException;
import com.cloud.exception.ResourceUnavailableException;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.network.IpAddress;
import com.cloud.network.Network;
import com.cloud.network.Network.Provider;
import com.cloud.network.Network.Service;
import com.cloud.network.PhysicalNetwork;
import com.cloud.network.addr.PublicIp;
import com.cloud.network.vpc.PrivateGateway;
import com.cloud.network.vpc.StaticRoute;
import com.cloud.network.vpc.Vpc;
import com.cloud.network.vpc.VpcGateway;
import com.cloud.network.vpc.VpcManager;
import com.cloud.network.vpc.VpcOffering;
import com.cloud.network.vpc.VpcService;
import com.cloud.offering.NetworkOffering;
import com.cloud.user.Account;
import com.cloud.user.User;
import com.cloud.utils.Pair;
import com.cloud.utils.component.ComponentLocator;
import com.cloud.utils.component.Manager;
import com.cloud.vm.DomainRouterVO;
import com.cloud.vpc.dao.MockVpcDaoImpl;

@Local(value = { VpcManager.class, VpcService.class })
public class MockVpcManagerImpl implements VpcManager, Manager{
    MockVpcDaoImpl _vpcDao = ComponentLocator.inject(MockVpcDaoImpl.class);

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getVpcOffering(long)
     */
    @Override
    public VpcOffering getVpcOffering(long vpcOfferingId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#createVpcOffering(java.lang.String, java.lang.String, java.util.List)
     */
    @Override
    public VpcOffering createVpcOffering(String name, String displayText, List<String> supportedServices) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getVpc(long)
     */
    @Override
    public Vpc getVpc(long vpcId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getActiveVpc(long)
     */
    @Override
    public Vpc getActiveVpc(long vpcId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getVpcNetworks(long)
     */
    @Override
    public List<? extends Network> getVpcNetworks(long vpcId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getVpcOffSvcProvidersMap(long)
     */
    @Override
    public Map<Service, Set<Provider>> getVpcOffSvcProvidersMap(long vpcOffId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#listVpcOfferings(java.lang.Long, java.lang.String, java.lang.String, java.util.List, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long)
     */
    @Override
    public List<? extends VpcOffering> listVpcOfferings(Long id, String name, String displayText, List<String> supportedServicesStr, Boolean isDefault, String keyword, String state, Long startIndex, Long pageSizeVal) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#deleteVpcOffering(long)
     */
    @Override
    public boolean deleteVpcOffering(long offId) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#updateVpcOffering(long, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public VpcOffering updateVpcOffering(long vpcOffId, String vpcOfferingName, String displayText, String state) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#createVpc(long, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Vpc createVpc(long zoneId, long vpcOffId, long vpcOwnerId, String vpcName, String displayText, String cidr, String networkDomain) throws ResourceAllocationException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#deleteVpc(long)
     */
    @Override
    public boolean deleteVpc(long vpcId) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#updateVpc(long, java.lang.String, java.lang.String)
     */
    @Override
    public Vpc updateVpc(long vpcId, String vpcName, String displayText) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#listVpcs(java.lang.Long, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.util.Map, java.lang.Long)
     */
    @Override
    public List<? extends Vpc> listVpcs(Long id, String vpcName, String displayText, List<String> supportedServicesStr, String cidr, Long vpcOffId, String state, String accountName, Long domainId, String keyword,
            Long startIndex, Long pageSizeVal, Long zoneId, Boolean isRecursive, Boolean listAll, Boolean restartRequired, Map<String, String> tags, Long projectId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#startVpc(long, boolean)
     */
    @Override
    public boolean startVpc(long vpcId, boolean destroyOnFailure) throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#shutdownVpc(long)
     */
    @Override
    public boolean shutdownVpc(long vpcId) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#restartVpc(long)
     */
    @Override
    public boolean restartVpc(long id) throws ConcurrentOperationException, ResourceUnavailableException, InsufficientCapacityException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getVpcPrivateGateway(long)
     */
    @Override
    public PrivateGateway getVpcPrivateGateway(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#createVpcPrivateGateway(long, java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)
     */
    @Override
    public PrivateGateway createVpcPrivateGateway(long vpcId, Long physicalNetworkId, String vlan, String ipAddress, String gateway, String netmask, long gatewayOwnerId) throws ResourceAllocationException,
            ConcurrentOperationException, InsufficientCapacityException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#applyVpcPrivateGateway(long, boolean)
     */
    @Override
    public PrivateGateway applyVpcPrivateGateway(long gatewayId, boolean destroyOnFailure) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#deleteVpcPrivateGateway(long)
     */
    @Override
    public boolean deleteVpcPrivateGateway(long gatewayId) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#listPrivateGateway(com.cloud.api.commands.ListPrivateGatewaysCmd)
     */
    @Override
    public Pair<List<PrivateGateway>, Integer> listPrivateGateway(ListPrivateGatewaysCmd listPrivateGatewaysCmd) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getStaticRoute(long)
     */
    @Override
    public StaticRoute getStaticRoute(long routeId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#applyStaticRoutes(long)
     */
    @Override
    public boolean applyStaticRoutes(long vpcId) throws ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#revokeStaticRoute(long)
     */
    @Override
    public boolean revokeStaticRoute(long routeId) throws ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#createStaticRoute(long, java.lang.String)
     */
    @Override
    public StaticRoute createStaticRoute(long gatewayId, String cidr) throws NetworkRuleConflictException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#listStaticRoutes(com.cloud.api.commands.ListStaticRoutesCmd)
     */
    @Override
    public Pair<List<? extends StaticRoute>, Integer> listStaticRoutes(ListStaticRoutesCmd cmd) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#getVpcGateway(long)
     */
    @Override
    public VpcGateway getVpcGateway(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#associateIPToVpc(long, long)
     */
    @Override
    public IpAddress associateIPToVpc(long ipId, long vpcId) throws ResourceAllocationException, ResourceUnavailableException, InsufficientAddressCapacityException, ConcurrentOperationException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcService#updateVpcGuestNetwork(long, java.lang.String, java.lang.String, com.cloud.user.Account, com.cloud.user.User, java.lang.String, java.lang.Long, java.lang.Boolean)
     */
    @Override
    public Network updateVpcGuestNetwork(long networkId, String name, String displayText, Account callerAccount, User callerUser, String domainSuffix, Long ntwkOffId, Boolean changeCidr) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#validateNtkwOffForVpc(long, java.lang.String, java.lang.String, com.cloud.user.Account, com.cloud.network.vpc.Vpc, java.lang.Long, java.lang.String)
     */
    @Override
    public void validateNtkwOffForVpc(long ntwkOffId, String cidr, String networkDomain, Account networkOwner, Vpc vpc, Long networkId, String gateway) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#getVpcsForAccount(long)
     */
    @Override
    public List<? extends Vpc> getVpcsForAccount(long accountId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#destroyVpc(com.cloud.network.vpc.Vpc)
     */
    @Override
    public boolean destroyVpc(Vpc vpc, Account caller, Long callerUserId) throws ConcurrentOperationException, ResourceUnavailableException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#getVpcRouters(long)
     */
    @Override
    public List<DomainRouterVO> getVpcRouters(long vpcId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#vpcProviderEnabledInZone(long)
     */
    @Override
    public boolean vpcProviderEnabledInZone(long zoneId) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#getPrivateGatewayForVpc(long)
     */
    @Override
    public VpcGateway getPrivateGatewayForVpc(long vpcId) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#ipUsedInVpc(com.cloud.network.IpAddress)
     */
    @Override
    public boolean ipUsedInVpc(IpAddress ip) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#unassignIPFromVpcNetwork(long, long)
     */
    @Override
    public void unassignIPFromVpcNetwork(long ipId, long networkId) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#createVpcGuestNetwork(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.cloud.user.Account, java.lang.Long, com.cloud.network.PhysicalNetwork, long, com.cloud.acl.ControlledEntity.ACLType, java.lang.Boolean, long, com.cloud.user.Account)
     */
    @Override
    public Network createVpcGuestNetwork(long ntwkOffId, String name, String displayText, String gateway, String cidr, String vlanId, String networkDomain, Account owner, Long domainId, PhysicalNetwork pNtwk,
            long zoneId, ACLType aclType, Boolean subdomainAccess, long vpcId, Account caller) throws ConcurrentOperationException, InsufficientCapacityException, ResourceAllocationException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#assignSourceNatIpAddressToVpc(com.cloud.user.Account, com.cloud.network.vpc.Vpc)
     */
    @Override
    public PublicIp assignSourceNatIpAddressToVpc(Account owner, Vpc vpc) throws InsufficientAddressCapacityException, ConcurrentOperationException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.utils.component.Manager#configure(java.lang.String, java.util.Map)
     */
    @Override
    public boolean configure(String name, Map<String, Object> params) throws ConfigurationException {
        // TODO Auto-generated method stub
        return true;
    }

    /* (non-Javadoc)
     * @see com.cloud.utils.component.Manager#start()
     */
    @Override
    public boolean start() {
        // TODO Auto-generated method stub
        return true;
    }

    /* (non-Javadoc)
     * @see com.cloud.utils.component.Manager#stop()
     */
    @Override
    public boolean stop() {
        // TODO Auto-generated method stub
        return true;
    }

    /* (non-Javadoc)
     * @see com.cloud.utils.component.Manager#getName()
     */
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#validateNtwkOffForVpc(com.cloud.offering.NetworkOffering, java.util.List)
     */
    @Override
    public void validateNtwkOffForVpc(NetworkOffering guestNtwkOff, List<Service> supportedSvcs) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see com.cloud.network.vpc.VpcManager#getSupportedVpcHypervisors()
     */
    @Override
    public List<HypervisorType> getSupportedVpcHypervisors() {
        // TODO Auto-generated method stub
        return null;
    }

}
