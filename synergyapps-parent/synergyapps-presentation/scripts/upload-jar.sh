#!/bin/sh
scp -i /home/will/.ssh/synergy/id_rsa /home/will/git/synergy-java-client/synergyapps-parent/synergyapps-presentation/target/synergyapps-presentation-1.0-SNAPSHOT-jar-with-dependencies.jar root@10.10.11.29:/root
#echo "Hello Chao"