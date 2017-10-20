SUMMARY = "Driver for Ralink rt73 USB 802.11g WiFi sticks"
HOMEPAGE = "http://www.ralinktech.com.tw"
SECTION = "kernel/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://../../COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

COMPATIBLE_MACHINE = "${@bb.utils.contains('MACHINEBUILD', 'japhar', 'dm(800$|800se$|8000$|500hd$)' , 'dm800', d)}"

DEPENDS = "firmware-rt73"

RREPLACES_${PN} = "rt73-k2wrlz"
RCONFLICTS_${PN} = "rt73-k2wrlz"

MACHINE_KERNEL_PR_append = ".2"

SRC_URI = "http://archiv.openmips.com/RT73.tar.gz \
           file://COPYING"

inherit module
 
S = "${WORKDIR}/RT73/Module/"
 
EXTRA_OEMAKE = "KERNDIR=${STAGING_KERNEL_DIR} KDIR=${STAGING_KERNEL_DIR}"

do_compile () {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS CC LD CPP
    oe_runmake 'MODPATH={D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net' \
        'KERNEL_SOURCE=${STAGING_KERNEL_DIR}' \
        'LINUX_SRC=${STAGING_KERNEL_DIR}' \
        'KDIR=${STAGING_KERNEL_DIR}' \
        'KERNDIR=${STAGING_KERNEL_DIR}' \
        'KERNEL_VERSION=${KERNEL_VERSION}' \
        'CC=${KERNEL_CC}' \
        'LD=${KERNEL_LD}'
}

export MB="${MACHINEBUILD}"
export TM="${MACHINE}"

do_install() {
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
    install -m 0644 rt73${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/
    if [ "$TM" = "dm800" ] && [ "$MB" = "estar" ]
    then
        echo "not auto-loading on e-star dm800!"
    else
        install -d ${D}/etc/modules-load.d
        echo rt73 > ${D}/etc/modules-load.d/rt73.conf
    fi
}

FILES_${PN}_append = " \
        ${sysconfdir}/Wireless \
        ${sysconfdir}/modules-load.d \
"

SRC_URI[md5sum] = "2f3cdfa8add042dae70a58c9a9138c78"
SRC_URI[sha256sum] = "cae651c8add4c40358ed169c648310f0ba577a57c14fe202a85904403a4ec157"
