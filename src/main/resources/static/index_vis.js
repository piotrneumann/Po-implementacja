function validate() {

    if (document.getElementById("check").checked) {
        document.getElementById("input_kurs_zam").style.visibility = "visible";
    } else {
        document.getElementById("input_kurs_zam").style.visibility = "hidden";
    }
}
