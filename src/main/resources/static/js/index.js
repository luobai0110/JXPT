//layui的支持js
layui.use('element', function () {
    const element = layui.element;
});

layui.use('carousel', function () {
    const carousel = layui.carousel;
    //建造实例
    carousel.render({
        elem: '#test1'
        , width: '100%' //设置容器宽度
        , arrow: 'always' //始终显示箭
    });
});

//自写js

//获得所有课程
$("#courses").ready(function () {
    $.get("course/courses", function (data, status) {
        const par = document.getElementById("courses");
        const courses = JSON.parse(JSON.stringify(data))
        for (let i = 0; i < 5; i++) {
            const nDiv = document.createElement("div");
            nDiv.className = "layui-col-md2";
            const div2 = document.createElement("div");
            div2.className = "layui-panel";
            div2.innerHTML = "课程名称" + courses[i].name + "\n" + "老师id" + courses[i].id;
            nDiv.appendChild(div2);
            par.appendChild(nDiv);
        }
    });
})

// 获得所有通知
$("#notice").ready(function () {
    $.get("notice", function (data, status) {
        let mask = 0;
        const parent = document.getElementById("notice");
        const notices = JSON.parse(JSON.stringify(data));
        for (let i = 0; i < notices.length; i++) {
            if (typeof (notices[i].title === 'undefined')) {
                const nLi = document.createElement("li");
                nLi.className = "list-group-item";
                nLi.innerHTML = "暂无通知";
                parent.appendChild(nLi)
                break;
            }
            const nLi = document.createElement("li");
            nLi.className = "list-group-item";
            const turn_to = document.createElement("a");
            turn_to.innerHTML = notices[i].title;
            turn_to.href = "/notice/" + notices[i].id;
            nLi.appendChild(turn_to);
            parent.appendChild(nLi)
            if (i > 4) {
                mask = 1;
                break;
            }
        }
        let nA = null;
        if (mask === 1) {
            nA = document.createElement("a");
            nA.innerHTML = "查看所有通知>>";
            nA.style = "color:blue";
            nA.href = "/notice/notices";
        }
        parent.appendChild(nA)
    })
})


// 获得所有学院
$("#schools").ready(function () {
    $.get("/school", function (data, status) {
        const par = document.getElementById("schools");
        const schools = JSON.parse(JSON.stringify(data));
        let n = 0;
        for (let i = 0; i < 5; i++) {
            const nTr = document.createElement("tr")
            for (let t = 0; t < 2; t++) {
                const nTd = document.createElement("td");
                nTd.innerHTML = schools[n].name;
                n++;
                nTr.appendChild(nTd);
            }
            par.appendChild(nTr);
        }
    })
})