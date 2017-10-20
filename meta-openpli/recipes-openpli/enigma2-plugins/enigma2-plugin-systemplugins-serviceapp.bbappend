SMALLFL = "${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "gstplayer", "exteplayer3 gstplayer", d)}"
RRECOMMENDS_${PN} = "${@bb.utils.contains("MACHINE_FEATURES", "exteplayeronly", "exteplayer3", "${SMALLFL}", d)}"

pkg_postinst_${PN}_exteplayeronly() {
	touch /etc/enigma2/serviceapp_replaceservicemp3
	if [ -e /etc/enigma2/settings ]
	then
		sed -i '/config.plugins.serviceapp.servicemp3.player=/d' /etc/enigma2/settings
		sed -i '/config.plugins.serviceapp.servicemp3.replace=/d' /etc/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" >> /etc/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> /etc/enigma2/settings
	else
		echo "config.plugins.serviceapp.servicemp3.player=exteplayer3" > /etc/enigma2/settings
		echo "config.plugins.serviceapp.servicemp3.replace=true" >> /etc/enigma2/settings
	fi
}
