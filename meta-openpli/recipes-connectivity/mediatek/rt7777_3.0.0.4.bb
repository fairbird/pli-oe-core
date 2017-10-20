DESCRIPTION = "Driver for Ralink rt7777 USB 802.11a/b/g/n/ac WiFi sticks"
HOMEPAGE = "www.mediatek.com"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
require conf/license/license-gplv2.inc

inherit module

SRC_URI = " \
	file://MT7601.zip \
	file://fwpath.patch \
	file://rt2870-mt7601Usta-kuid_t-kgid_t.patch \
	file://remove_linux_2_4_compability.patch \
	"

S = "${WORKDIR}/DPO_MT7601U_LinuxSTA_3.0.0.4_20130913"

MACHINE_KERNEL_PR_append = ".1"
EXTRA_OEMAKE = "LINUX_SRC=${STAGING_KERNEL_DIR}"

#EXTRA_OEMAKE = "KSRC=${STAGING_KERNEL_DIR}"

FILES_${PN} += " \
	${sysconfdir}/Wireless \
	/lib/firmware/ \
"

do_install() {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
    install -m 0644 ${S}/os/linux/mt7601Usta.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless/rt7777.ko
    install -d ${D}/etc/Wireless/RT7777
    install -m 0644 ${S}/RT2870STA.dat ${D}/etc/Wireless/RT7777
}
