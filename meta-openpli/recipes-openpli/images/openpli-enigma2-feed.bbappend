OPTIONAL_PACKAGES += " \
	sshfs-fuse \
	"

ENIGMA2_OPTIONAL_append = " \
	enigma2-plugin-extensions-dreamplex \
	enigma2-plugin-extensions-install-ffmpeg \
	enigma2-plugin-extensions-install-exteplayer3 \
	enigma2-plugin-extensions-install-gstplayer \
	enigma2-plugin-extensions-iptvplayer \
	enigma2-plugin-extensions-weathermsn \
	enigma2-plugin-skins-dreamplexskins \
	enigma2-plugin-skins-mx-hq9w \
	enigma2-plugin-skins-mx-hq7 \
	enigma2-plugin-skins-glamouraurafhd \
	${@bb.utils.contains('OPENPLI_FEATURES', 'qthbbtv', 'enigma2-plugin-extensions-hbbtv-qt', '', d)} \
	"
