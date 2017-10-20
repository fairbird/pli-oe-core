require linux-firmware.inc

DESCRIPTION = "Firmware for SDIO RTL8723BS"

do_install() {
	install -d ${D}${base_libdir}/firmware/rtlwifi
	install -m 0644 rtlwifi/rtl8723bs_ap_wowlan.bin ${D}${base_libdir}/firmware/rtlwifi/
	install -m 0644 rtlwifi/rtl8723bs_nic.bin ${D}/${base_libdir}/firmware/rtlwifi/
	install -m 0644 rtlwifi/rtl8723bs_wowlan.bin ${D}/${base_libdir}/firmware/rtlwifi/
	install -m 0644 rtlwifi/rtl8723bs_bt.bin ${D}/${base_libdir}/firmware/rtlwifi/
}
