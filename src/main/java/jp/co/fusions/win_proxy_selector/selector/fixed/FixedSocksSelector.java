package jp.co.fusions.win_proxy_selector.selector.fixed;

import java.net.InetSocketAddress;
import java.net.Proxy;

/*****************************************************************************
 * This proxy selector is configured with a fixed proxy. This proxy will be
 * returned for all URIs passed to the select method. This implementation can be
 * used for SOCKS 4 and 5 proxy support.
 *
 * @author Markus Bernhardt, Copyright 2016
 * @author Bernd Rosstauscher, Copyright 2009
 ****************************************************************************/

public class FixedSocksSelector extends FixedProxySelector {

	/*************************************************************************
	 * Constructor
	 * 
	 * @param proxyHost
	 *            the host name or IP address of the proxy to use.
	 * @param proxyPort
	 *            the port of the proxy.
	 ************************************************************************/

	public FixedSocksSelector(String proxyHost, int proxyPort) {
		super(new Proxy(Proxy.Type.SOCKS, InetSocketAddress.createUnresolved(proxyHost, proxyPort)));
	}

}
