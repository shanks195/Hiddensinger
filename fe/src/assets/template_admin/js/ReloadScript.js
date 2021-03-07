function reloadScript(url) {
    var script = document.createElement("script");
    script.setAttribute("type", "text/javascript");
    script.setAttribute("src", url);
    script.async = false;
    document.head.appendChild(script);
}
export default reloadScript;