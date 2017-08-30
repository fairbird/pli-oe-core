ENIGMA2_PLUGINS_append = " \
	${@bb.utils.contains("MACHINE_FEATURES", "smallflash", " \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-softcams-oscam", " \
	enigma2-plugin-systemplugins-serviceapp \
	enigma2-plugin-softcams-oscam \
	enigma2-plugin-extensions-youtube \
	enigma2-plugin-extensions-blurayplayer", d)} \
	"
