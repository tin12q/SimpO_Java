package com.httt.server.control.Server;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IpGet {
    private String ip;
    public static String getHostIP() {
        return hostIP;
    }

    public static void setHostIP(String hostIP) {
        IpGet.hostIP = hostIP;
    }
    private static String hostIP;
    public IpGet()  {
        //System.out.println("Your Host addr: " + InetAddress.getLocalHost().getHostName());  // often returns "127.0.0.1"

        try {
            String.valueOf(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        Enumeration<NetworkInterface> n = null;
        try {
            n = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        for (; n.hasMoreElements();) {
            NetworkInterface e = n.nextElement();

            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements(); ) {
                InetAddress addr = a.nextElement();
                String tmp = addr.toString();
                    if (tmp.startsWith("/192.168.")) {
                    ip = tmp.substring(1);
                    setHostIP(ip);
                }


                //System.out.println(ip+" "+tmp+"  " + hostIP);
            }
        }
    }


}
