package com.ilyamur.osgi.helloworld.client.impl;

import com.ilyamur.osgi.helloworld.service.OsgiHelloworldService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Activator implements BundleActivator {

    public void start(BundleContext context) throws Exception {
        System.out.println("osgi-helloworld-client start");

        ServiceReference[] refs = context.getServiceReferences(OsgiHelloworldService.class.getName(), "(Language=*)");

        if (refs != null) {

            System.out.println("Enter a blank line to exit.");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String word;

            while (true) {

                System.out.print("Enter name: ");
                word = in.readLine();

                if (word.length() == 0) {
                    break;
                }

                OsgiHelloworldService osgiHelloworldService = (OsgiHelloworldService) context.getService(refs[0]);
                System.out.println(osgiHelloworldService.getGreeting(word));
            }

            context.ungetService(refs[0]);
        } else {
            System.out.println("Couldn't find any OsgiHelloworldService...");
        }

    }

    public void stop(BundleContext context) {
        System.out.println("osgi-helloworld-client stop");
    }
}
