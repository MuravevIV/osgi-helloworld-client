package com.ilyamur.osgi.helloworld.client.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("osgi-helloworld-client start");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("osgi-helloworld-client stop");
    }
}
