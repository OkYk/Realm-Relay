Realm Relay
===========

A relay server, or proxy, designed for hacking Realm of the Mad God.

Build instructions
==================

Maven project - I use apache-maven-3.0.4 but, newer ones should be fine too.
Get Maven free here http://maven.apache.org/download.cgi

Java JDK required: Java 1.7.0_51 for build. For execution JRE of the same version is fine.

Maven command for build:
mvn clean package

Result - target\realmrelay-1.0.jar

Place it along with "xml", "scripts" and "settings.properties" to the same folder, open the console in that folder and run the relay:
java -jar realmrelay-1.0.jar

If you are lucky to work on *nix machine you can use iptables rule to redirect connection from one of realms to your local machine:
sudo iptables -t nat -A OUTPUT -p tcp -d 54.195.57.43 --dport 2050 -j DNAT --to-destination 127.0.0.1:2050
sudo /sbin/service iptables save

54.195.57.43 is EUWest1 realm, so you can play on the official client if you want

P.S in that case one of realms will be unavailable to you, sorry for that, that's the payment for playing on official client
