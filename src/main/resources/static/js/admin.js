// 页面加载时自动获取
$("#schools").ready(function () {
    $.get("/school/schools",function (data, status) {
        const contents = document.getElementById("contents");
        const schools = JSON.parse(JSON.stringify(data));
       if (typeof schools[0].name !== 'undefined') createContent(contents,schools,"school");
    })
})

// 函数：具体实现如何获得

function createContent(parent, data,type) {
    for (let i = 0; i <= data.length; i++) {
        const nDiv = document.createElement("div");
        const nCard = document.createElement("div");
        const cardBody = document.createElement("div");
        nDiv.className="col-3";
        nCard.className="card";
        cardBody.className="card-body d-grid";
        const nA = document.createElement("a");
        if (i === data.length) {
            nA.innerHTML='\u002B'
            nA.href=type + "/add";
        } else {
            nA.innerHTML=data[i].name;
            nA.href=type + "/" + data[i].id;
        }
        nA.className="btn btn-block";
        cardBody.appendChild(nA);
        nCard.appendChild(cardBody);
        nDiv.appendChild(nCard);
        parent.appendChild(nDiv);
    }
}

// 获得某个类型的所有内容
function getContents(type) {
    $.get("/" + type + "/" + type + "s", function (data, status) {
        document.getElementById("contents").innerHTML="";
        const contents = document.getElementById("contents");
        const schools = JSON.parse(JSON.stringify(data));
        if (typeof schools[0].name !== 'undefined') createContent(contents,schools,type);
    })
}
// 获取具体的内容
function getInfo(id,type) {
    document.getElementById("contents").innerHTML="";
    $.get("/" + type + "/" +id, function (data, status) {

    })
}
