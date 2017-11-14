# Qt packages are machine specific
QT_PACKAGES_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN}_hd51 += "hd-v3ddriver-${MACHINE} hd-qteglfs-platform"
RDEPENDS_${PN}_vs1500 += "hd-v3ddriver-${MACHINE} hd-qteglfs-platform"
RDEPENDS_${PN}_hd2400 += "hd-v3ddriver-${MACHINE} hd-qteglfs-platform"
RDEPENDS_${PN}_bre2ze4k += "hd-v3ddriver-${MACHINE} hd-qteglfs-platform"
RDEPENDS_${PN}_osmega += "v3d-libgles-${MACHINE}"
RDEPENDS_${PN}_h7 += "zgemma-v3ddriver-${MACHINE}"
RDEPENDS_${PN}_vuduo2 += "libgles-${MACHINE}"
RDEPENDS_${PN}_vuuno4k += "libgles-${MACHINE}"
RDEPENDS_${PN}_vuuno4kse += "libgles-${MACHINE}"
RDEPENDS_${PN}_vuultimo4k += "libgles-${MACHINE}"
RDEPENDS_${PN}_vusolo2 += "libgles-${MACHINE}"
RDEPENDS_${PN}_vusolo4k += "libgles-${MACHINE}"
RDEPENDS_${PN}_vusolose += "libgles-${MACHINE}"

PACKAGECONFIG += "gles2 eglfs gif linuxfb glib openssl directfb"
