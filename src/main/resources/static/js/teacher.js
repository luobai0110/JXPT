$("#t_class").ready(function () {
    $.get("/t_class/t_classes",function (data,status) {
        const tClass2 = JSON.parse(JSON.stringify(data));
        let titleName=["编号","专业","课程","班级","操作"]
        addContent("tHeadParent",titleName, "title");
        for (let i = 0 ; i < tClass2.length; i++) {
            let nTds = [tClass2[i].tclassId,tClass2[i].majorName,tClass2[i].courseName,tClass2[i].tclassName,tClass2[i].tclassId];
            addContent("tBodyParent",nTds, "body");
        }
    })
})

function addContent(parent, nTds, type) {
    const nTr = document.createElement("tr");
    let nA = null
    let nTd = null
    for (let i = 0; i < nTds.length;i++) {
        if (type === "title")  nTd = document.createElement("th");
        else  nTd = document.createElement("td");
        if (i === nTds.length - 1 && type !== "title") {
            nA = document.createElement("a")
            nA.href="/t_class/" + nTds[nTds.length]
            nA.innerHTML="查看"
            nTd.appendChild(nA);
            nTr.appendChild(nTd);
            break;
        }
        nTd.innerHTML=nTds[i];
        nTr.appendChild(nTd);
    }
    document.getElementById(parent).appendChild(nTr);
}

