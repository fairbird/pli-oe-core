# Qt packages are machine specific
QT_PACKAGES_ARCH = "${MACHINE_ARCH}"

CFLAGS_append_galaxy4k = " -DBROADCOM_PLATFORM=1 "
CXXFLAGS_append_galaxy4k = " -DBROADCOM_PLATFORM=1 "
CFLAGS_append_revo4k = " -DBROADCOM_PLATFORM=1 "
CXXFLAGS_append_revo4k = " -DBROADCOM_PLATFORM=1 "

PACKAGECONFIG += "gles2 eglfs gif linuxfb glib openssl directfb"
