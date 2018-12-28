package jp.co.fusions.win_proxy_selector.selector.fixed;

import static org.junit.Assert.assertEquals;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;

import org.junit.Test;

import jp.co.fusions.win_proxy_selector.TestUtil;

/*****************************************************************************
 * 
 * @author Markus Bernhardt, Copyright 2016
 * @author Bernd Rosstauscher, Copyright 2009
 ****************************************************************************/

public class FixedProxyTest {

	/*************************************************************************
	 * Test method
	 ************************************************************************/
	@Test
	public void testFixedProxy() {
		ProxySelector ps = new FixedProxySelector("http_proxy.unit-test.invalid", 8090);

		List<Proxy> result = ps.select(TestUtil.HTTP_TEST_URI);
		assertEquals(TestUtil.HTTP_TEST_PROXY, result.get(0));
	}

	/*************************************************************************
	 * Test method
	 ************************************************************************/
	@Test
	public void testFixedProxy2() {
		ProxySelector ps = new FixedProxySelector(TestUtil.HTTP_TEST_PROXY);

		List<Proxy> result = ps.select(TestUtil.HTTP_TEST_URI);
		assertEquals(TestUtil.HTTP_TEST_PROXY, result.get(0));
	}

	/*************************************************************************
	 * Test method
	 ************************************************************************/
	@Test
	public void testFixedProxy3() {
		ProxySelector ps = new FixedProxySelector(TestUtil.HTTP_TEST_PROXY);

		List<Proxy> result = ps.select(TestUtil.HTTPS_TEST_URI);
		assertEquals(TestUtil.HTTP_TEST_PROXY, result.get(0));
	}

}
