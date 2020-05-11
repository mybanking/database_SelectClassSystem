window.onload = function() {
    this.nameFunction();
    this.tableSchemasFunction();
}

function nameFunction() {
    var name = "孔德焱";
    document.getElementById("home_head_name").innerHTML = "17301066:" + name;
}

function tableSchemasFunction() {
    var line = "<tr><td>1</td><td>Data Base System</td><td><time>14:10</time>-<time>16:00</time></td><td>YF708</td></tr>";
    document.getElementById("home_table_schedule").append = line;
}
