package jp.co.fusions.win_proxy_selector.util;

import jp.co.fusions.win_proxy_selector.TestUtil;
import static org.junit.Assert.assertEquals;

import java.net.Proxy;
import java.util.List;

import org.junit.Test;

import jp.co.fusions.win_proxy_selector.selector.fixed.FixedProxySelector;

/*****************************************************************************
 * Unit tests for proxy util methods
 * 
 * @author Markus Bernhardt, Copyright 2016
 * @author Bernd Rosstauscher, Copyright 2009
 ****************************************************************************/

public class ProxyUtilTest {

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseProxySettings() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("http://http_proxy.unit-test.invalid/");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ http_proxy.unit-test.invalid:80", psList.get(0).toString());
	}

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseProxySettings2() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("http://http_proxy.unit-test.invalid:8080/");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ http_proxy.unit-test.invalid:8080", psList.get(0).toString());
	}

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseProxySettings3() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("http_proxy.unit-test.invalid");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ http_proxy.unit-test.invalid:80", psList.get(0).toString());
	}

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseProxySettings4() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("http_proxy.unit-test.invalid:8080");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ http_proxy.unit-test.invalid:8080", psList.get(0).toString());
	}

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseProxySettings5() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("192.123.123.1:8080");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ 192.123.123.1:8080", psList.get(0).toString());
	}

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseIPv6WithoutProtocol() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("[2001:4860:0:2001::68]:8080");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ 2001:4860:0:2001::68:8080", psList.get(0).toString());
	}

	/*************************************************************************
	 * Test parsing method.
	 ************************************************************************/

	@Test
	public void testParseIPv6WithProtocol() {
		FixedProxySelector rs = ProxyUtil.parseProxySettings("http://[2001:4860:0:2001::68]:8080/");
		List<Proxy> psList = rs.select(TestUtil.HTTP_TEST_URI);
		assertEquals("HTTP @ 2001:4860:0:2001::68:8080", psList.get(0).toString());
	}

}
