var enterpriseEsUrl = "enterprise/enterpriseEsSearch/esEnterpriseAggregationSearch";
var executionEsUrl = "execution/executionEsSearch/esExecutionAggregationSearch";
var esUrl = "";
var esParams = {
    indexType : ""
};

//加载图表
function loadChartDiv(elementType){
    var jsonStr = {
        elementType : elementType,
        isSearchDepartment : isSearchDepartment
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getQueryElementsChartsList";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0"){
        var data = result.data;
        var chartLength = 4;
        if(data.length < 4){
            chartLength = data.length;
        }
        for(var i = 0;i < chartLength;i ++){
            var groupElements = [];
            var parentTab = data[i].parentTab;
            if(parentTab == "enterprise"){
                esUrl = enterpriseEsUrl;
            }else if(parentTab == "execution"){
                esUrl = executionEsUrl;
                esParams.indexType = "execution";
            }else if(parentTab == "accident"){
                esUrl = executionEsUrl;
                esParams.indexType = "accident";
            }else{
                esUrl = enterpriseEsUrl;
            }
            var returnTab = data[i].returnTab;
            var returnTabText = data[i].returnTabText;
            var returnTabUrl = data[i].returnTabUrl;
            var chartUnit = data[i].chartUnit;
            var chartType = data[i].chartType;
            var searchElements = {
                chartUnit : chartUnit,
                chartType : chartType,
                returnTabUrl : returnTabUrl,
                returnTabText : returnTabText,
                tab_relation : "",
                tab_parent : parentTab,
                agg_items : [{
                    item_text : returnTabText,
                    tab_return : returnTab,
                    item_eles : []
                }]
            };
            var chartId = data[i].chartId;
            var chartName = data[i].chartName;
            var divHtml = "<div class=\"layui-col-md3 chartDiv\" style=\"margin-top: 10px;padding-bottom: 0px\">\n" +
                "            <div class=\"layui-card regulatory-information\">\n" +
                "                <div class=\"layui-card-header\">" +
                                    "<div id='chartNameDiv_"+(i+1)+"' style='width: 60%;display:inline-block'>" +
                                        "<a href='#' style='color: white;cursor: pointer;'><span id='chartNameSpan_"+(i+1)+"'>"+chartName+"</span>（共<span id='chartNumSpan_"+(i+1)+"'>0</span>条）</a>" +
                                    "</div>"+
                                    "<input type='hidden' id='chartGroupElement_"+(i+1)+"' value=''/>"+
                                    "<input type='hidden' id='chartResultElement_"+(i+1)+"' value=''/>"+
                                    "<div class='elementSelect'>" +
                                        "<select id='elementSelect_"+(i+1)+"' name='elementSelect' lay-filter='elementSelect'></select>" +
                                    "</div>" +
                                "</div>\n" +
                "                <div class=\"layui-card-body\" style='padding: 0px'>\n" +
                "                    <div id=\"chartDiv_"+(i+1)+"\" style=\"height: 250px;margin: auto;\"></div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>";
            $("#chartsDiv").append(divHtml);
            //加载下拉框
            loadSelect((i+1),chartId,data);
            var chartsSeries = data[i].chartsSeries;
            var dataType = data[i].dataType;
            if(dataType == "2"){
                var dataUrl = chartsSeries[0].dataUrl;
                var dataParams = chartsSeries[0].dataParams;
                var resultParams = chartsSeries[0].resultParams;
                var isEndNode = chartsSeries[0].isEndNode;
                var elementId = chartsSeries[0].elementId;
                var dataObj = JSON.parse(dataParams);
                var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
                var resultParamId = resultParams.split("||")[0];
                var resultParamName = resultParams.split("||")[1];
                if(loadDataResult instanceof Array){
                    for(var j = 0;j < loadDataResult.length;j ++){
                        var item_name = loadDataResult[j][resultParamName];
                        var item_eles =  JSON.parse(JSON.stringify(chartsSeries[0].item_eles));
                        for(var k = 0;k < item_eles.length;k ++){
                            for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                                if(item_eles[k].tab_eles[m].que_val == undefined
                                    || item_eles[k].tab_eles[m].que_val == ""){
                                    item_eles[k].tab_eles[m].que_val = loadDataResult[j][resultParamId];
                                }
                            }
                        }
                        var seriesElement = {
                            item_name : item_name,
                            item_eles : item_eles,
                            isEndNode : isEndNode,
                            elementId : elementId,
                            resultData : loadDataResult[j][resultParamId]
                        };
                        groupElements.push(seriesElement);
                    }
                }else{
                    if(loadDataResult.code == "0"){
                        var loadDataResultData = loadDataResult.data;
                        for(var j = 0;j < loadDataResultData.length;j ++){
                            var item_name = loadDataResultData[j][resultParamName];
                            var item_eles =  JSON.parse(JSON.stringify(chartsSeries[0].item_eles));
                            item_eles[0].tab_eles[0].que_val = loadDataResultData[j][resultParamId];
                            var seriesElement = {
                                item_name : item_name,
                                item_eles : item_eles,
                                isEndNode : isEndNode,
                                elementId : elementId,
                                resultData : loadDataResultData[j][resultParamId]
                            };
                            groupElements.push(seriesElement);
                        }
                    }
                }
            }else if(dataType == "3"){
                for(var j = 0;j < chartsSeries.length;j ++){
                    var dataUrl = chartsSeries[j].dataUrl;
                    var dataParams = chartsSeries[j].dataParams;
                    var resultParams = chartsSeries[j].resultParams;
                    var isEndNode = chartsSeries[j].isEndNode;
                    var elementId = chartsSeries[j].elementId;
                    var dataObj = JSON.parse(dataParams);
                    var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
                    var resultParamId = resultParams.split("||")[0];
                    var resultParamName = resultParams.split("||")[1];
                    var item_name = chartsSeries[j].item_name;
                    var item_eles = chartsSeries[j].item_eles;
                    var seriesElement = {
                        item_name : item_name,
                        isEndNode : isEndNode,
                        elementId : elementId,
                        item_eles : item_eles,
                        seriesColor : chartsSeries[j].seriesColor
                    };
                    var queValue = "";
                    if(loadDataResult instanceof Array){
                        for(var k = 0;k < loadDataResult.length;k ++){
                            queValue += loadDataResult[k][resultParamId] + ",";
                        }
                        if(queValue != undefined && queValue != ""){
                            queValue = queValue.substr(0,queValue.length - 1);
                        }
                    }else{
                        if(loadDataResult.code == "0"){
                            var loadDataResultData = loadDataResult.data;
                            for(var k = 0;k < loadDataResultData.length;k ++){
                                queValue += loadDataResultData[k][resultParamId] + ",";
                            }
                            if(queValue != undefined && queValue != ""){
                                queValue = queValue.substr(0,queValue.length - 1);
                            }
                        }
                    }
                    seriesElement.resultData = queValue;
                    for(var k = 0;k < item_eles.length;k ++){
                        for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                            if(item_eles[k].tab_eles[m].que_val == undefined
                                || item_eles[k].tab_eles[m].que_val == ""){
                                item_eles[k].tab_eles[m].que_val = queValue;
                            }
                        }
                    }
                    groupElements.push(seriesElement);
                }
            }else if(dataType == "9"){
                var dataArray = searhCrossData(chartsSeries,groupElements,searchElements);
                //图表总数
                var totalNum = 0;
                for(var j in dataArray){
                    totalNum += dataArray[j].value;
                }
                $("#chartNumSpan_"+(i+1)).html(totalNum);
                createChart("chartDiv_"+(i+1),chartName,dataArray);
                $("#chartGroupElement_"+(i+1)).val(JSON.stringify(groupElements));
                $("#chartResultElement_"+(i+1)).val(JSON.stringify(searchElements));
                $("#chartNameDiv_"+(i+1)).on("click",function(){
                    openAllElementList(this,true);
                });
                continue;
            }else{
                for(var j = 0;j < chartsSeries.length;j ++){
                    var seriesElement = {
                        item_name : chartsSeries[j].item_name,
                        item_eles : chartsSeries[j].item_eles,
                        seriesColor : chartsSeries[j].seriesColor,
                        isEndNode : chartsSeries[j].isEndNode,
                        elementId : chartsSeries[j].elementId
                    };
                    groupElements.push(seriesElement);
                }
            }
            if(extraDefaultElement != null){
                searchElements.agg_items[0].item_eles = extraDefaultElement;
            }
            $("#chartGroupElement_"+(i+1)).val(JSON.stringify(groupElements));
            $("#chartResultElement_"+(i+1)).val(JSON.stringify(searchElements));
            $("#chartNameDiv_"+(i+1)).on("click",function(){
                openAllElementList(this,false);
                //loadAllBlockDiv(this,false);
            });
            var dataArray = searhData(groupElements,searchElements);
            //图表总数
            var totalNum = 0;
            for(var j in dataArray){
                totalNum += dataArray[j].value;
            }
            $("#chartNumSpan_"+(i+1)).html(totalNum);
            createChart("chartDiv_"+(i+1),chartName,dataArray);
        }
        form.render();
    }
}

function loadSelect(chartId,selectedId,data){
    var chartSelect = document.getElementById("elementSelect_"+chartId);
    for(var i = 0;i < data.length;i ++){
        chartSelect.add(new Option(data[i].chartName,data[i].chartId));
    }
    $("#elementSelect_"+chartId).val(selectedId);
}

function searhData(groupElements,searchElements){
    var jsonStr = {
        //分组参数
        elements : []
        //聚和参数
        ,resultElementJson : searchElements
    };
    var chartUnit = searchElements.chartUnit;
    jsonStr.elements = groupElements;
    var url = contextPath + esUrl;
    if(esParams.indexType != ""){
        jsonStr.indexType = esParams.indexType;
    }
    var result = loadingAjaxJsonData(url, jsonStr);
    var dataArray = [];
    if(result.code === "0") {
        var data = result.data;
        var content = data[0].item_content;
        for(var j = 0;j < groupElements.length;j ++){
            for(var i = 0;i < content.length;i ++){
                if(groupElements[j].item_name == content[i].key){
                    var element = {};
                    element = groupElements[j];
                    var dataContent = {
                        name : content[i].key,
                        chartUnit : chartUnit,
                        value : content[i].doc_count,
                        element : element,
                        resultElement : searchElements
                    };
                    if(groupElements[j].seriesColor != undefined && groupElements[j].seriesColor != ""){
                        dataContent.itemStyle = {color : groupElements[j].seriesColor};
                    }
                    dataArray.push(dataContent);
                }
            }
        }
    }
    return dataArray;
}

//重载图表
function reLoadChartDiv(chartDivId,elementId){
    var jsonStr = {
        elementId : elementId
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getQueryElementsChartById";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0") {
        var data = result.data;
        var groupElements = [];
        var parentTab = data.parentTab;
        if(parentTab == "enterprise"){
            esUrl = enterpriseEsUrl;
        }else if(parentTab == "execution"){
            esUrl = executionEsUrl;
            esParams.indexType = "execution";
        }else if(parentTab == "accident"){
            esUrl = executionEsUrl;
            esParams.indexType = "accident";
        }else{
            esUrl = enterpriseEsUrl;
        }
        var returnTab = data.returnTab;
        var returnTabText = data.returnTabText;
        var returnTabUrl = data.returnTabUrl;
        var chartUnit = data.chartUnit;
        var chartType = data.chartType;
        var searchElements = {
            chartUnit : chartUnit,
            chartType : chartType,
            returnTabUrl : returnTabUrl,
            returnTabText : returnTabText,
            tab_relation : "",
            tab_parent : parentTab,
            agg_items : [{
                item_text : returnTabText,
                tab_return : returnTab,
                item_eles : []
            }]
        };
        var chartId = data.chartId;
        var chartName = data.chartName;
        var chartsSeries = data.chartsSeries;
        var dataType = data.dataType;
        if (dataType == "2") {
            var dataUrl = chartsSeries[0].dataUrl;
            var dataParams = chartsSeries[0].dataParams;
            var resultParams = chartsSeries[0].resultParams;
            var isEndNode = chartsSeries[0].isEndNode;
            var elementId = chartsSeries[0].elementId;
            var dataObj = JSON.parse(dataParams);
            var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
            var resultParamId = resultParams.split("||")[0];
            var resultParamName = resultParams.split("||")[1];
            if (loadDataResult instanceof Array) {
                for (var i = 0; i < loadDataResult.length; i++) {
                    var item_name = loadDataResult[i][resultParamName];
                    var item_eles = JSON.parse(JSON.stringify(chartsSeries[0].item_eles));
                    item_eles[0].tab_eles[0].que_val = loadDataResult[i][resultParamId];
                    var seriesElement = {
                        item_name: item_name,
                        item_eles: item_eles,
                        isEndNode: isEndNode,
                        elementId: elementId,
                        resultData: loadDataResult[i][resultParamId]
                    };
                    groupElements.push(seriesElement);
                }
            } else {
                if(loadDataResult.code == "0"){
                    var loadDataResultData = loadDataResult.data;
                    for (var i = 0; i < loadDataResultData.length; i++) {
                        var item_name = loadDataResultData[i][resultParamName];
                        var item_eles = JSON.parse(JSON.stringify(chartsSeries[0].item_eles));
                        item_eles[0].tab_eles[0].que_val = loadDataResultData[i][resultParamId];
                        var seriesElement = {
                            item_name: item_name,
                            item_eles: item_eles,
                            isEndNode: isEndNode,
                            elementId: elementId,
                            resultData: loadDataResultData[i][resultParamId]
                        };
                        groupElements.push(seriesElement);
                    }
                }
            }
        }else if(dataType == "3"){
            for(var i = 0;i < chartsSeries.length;i ++){
                var dataUrl = chartsSeries[i].dataUrl;
                var dataParams = chartsSeries[i].dataParams;
                var resultParams = chartsSeries[i].resultParams;
                var isEndNode = chartsSeries[i].isEndNode;
                var elementId = chartsSeries[i].elementId;
                var dataObj = JSON.parse(dataParams);
                var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
                var resultParamId = resultParams.split("||")[0];
                var resultParamName = resultParams.split("||")[1];
                var item_name = chartsSeries[i].item_name;
                var item_eles = chartsSeries[i].item_eles;
                var seriesElement = {
                    item_name : item_name,
                    isEndNode : isEndNode,
                    elementId : elementId,
                    item_eles : item_eles,
                    seriesColor : chartsSeries[i].seriesColor
                };
                var queValue = "";
                if(loadDataResult instanceof Array){
                    for(var j = 0;j < loadDataResult.length;j ++){
                        queValue += loadDataResult[j][resultParamId] + ",";
                    }
                    if(queValue != undefined && queValue != ""){
                        queValue = queValue.substr(0,queValue.length - 1);
                    }
                }else{
                    if(loadDataResult.code == "0"){
                        var loadDataResultData = loadDataResult.data;
                        for(var k = 0;k < loadDataResultData.length;k ++){
                            queValue += loadDataResultData[k][resultParamId] + ",";
                        }
                        if(queValue != undefined && queValue != ""){
                            queValue = queValue.substr(0,queValue.length - 1);
                        }
                    }
                }
                seriesElement.resultData = queValue;
                for(var k = 0;k < item_eles.length;k ++){
                    for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                        if(item_eles[k].tab_eles[m].que_val == undefined
                            || item_eles[k].tab_eles[m].que_val == ""){
                            item_eles[k].tab_eles[m].que_val = queValue;
                        }
                    }
                }
                groupElements.push(seriesElement);
            }
        } else if(dataType == "9"){
            var dataArray = searhCrossData(chartsSeries,groupElements,searchElements);
            //图表总数
            var totalNum = 0;
            for(var j in dataArray){
                totalNum += dataArray[j].value;
            }
            $("#chartNumSpan_"+chartDivId).html(totalNum);
            $("#chartGroupElement_"+chartDivId).val(JSON.stringify(groupElements));
            $("#chartResultElement_"+chartDivId).val(JSON.stringify(searchElements));
            $("#chartNameDiv_"+chartDivId).unbind("click");
            $("#chartNameDiv_"+chartDivId).on("click",function(){
                openAllElementList(this,true);
            });
            createChart("chartDiv_"+chartDivId,chartName,dataArray);
            return false;
        } else {
            for (var i = 0; i < chartsSeries.length; i++) {
                var seriesElement = {
                    item_name: chartsSeries[i].item_name,
                    item_eles: chartsSeries[i].item_eles,
                    seriesColor: chartsSeries[i].seriesColor,
                    isEndNode: chartsSeries[i].isEndNode,
                    elementId: chartsSeries[i].elementId
                };
                groupElements.push(seriesElement);
            }
        }
        if(extraDefaultElement != null){
            searchElements.agg_items[0].item_eles = extraDefaultElement;
        }
        $("#chartGroupElement_"+chartDivId).val(JSON.stringify(groupElements));
        $("#chartResultElement_"+chartDivId).val(JSON.stringify(searchElements));
        $("#chartNameDiv_"+chartDivId).unbind("click");
        $("#chartNameDiv_"+chartDivId).on("click",function(){
            openAllElementList(this,false);
        });
        var dataArray = searhData(groupElements, searchElements);
        //图表总数
        var totalNum = 0;
        for(var j in dataArray){
            totalNum += dataArray[j].value;
        }
        $("#chartNumSpan_"+chartDivId).html(totalNum);
        createChart("chartDiv_" + chartDivId, chartName, dataArray);
    }
}

//组建图表
var chartArray = [];
function createChart(chartId,seriesText,dataArray){
    if(isSearchDepartment){
        var isBrigade = false;
        if(userOpptType == "4324"){
            isBrigade = true;
        }
        var departmentArray = [];
        for(var i in dataArray){
            var text = dataArray[i].name;
            if(isBrigade){
                if(text.indexOf("大队") != -1){
                    departmentArray.push(dataArray[i]);
                }
            }else{
                if(text.indexOf("街镇") != -1){
                    departmentArray.push(dataArray[i]);
                }
            }
            if(text.indexOf("街镇") == -1 && text.indexOf("大队") == -1 && text.indexOf("区局") == -1){
                departmentArray.push(dataArray[i]);
            }
        }
        dataArray = departmentArray;
    }
    for(var i = 0;i < chartArray.length;i ++){
        if(chartArray[i].id == chartId){
            chartArray[i].chart.clear();
            chartArray[i].chart.dispose();
        }
    }

    var chartDiv = echarts.init(document.getElementById(chartId),'shine');
    var chartJson = {
        id : chartId,
        chart : chartDiv
    };
    chartArray.push(chartJson);
    var option = {
        legend: {
            type:'scroll'
        },
        tooltip: {
            trigger: 'item',
            formatter: function (params, ticket, callback) {
                var seriesName = params.seriesName;
                var name = params.data.name;
                var unit = params.data.chartUnit;
                var value = params.data.value;
                var text = seriesName + "<br/>" +name + ":" + value + unit;
                return text;
            }
        },
        series: [
            {
                name:seriesText,
                type:'pie',
                minAngle:0,
                minShowLabelAngle:0.1,
                //radius : '55%',
                radius: ['40%', '60%'],
                center: ['50%', '50%'],
                avoidLabelOverlap: true,
                data:dataArray,
                label : {
                    formatter : function (params){
                        var name = params.data.name;
                        if(name.length > 4){
                            name = name.substr(0,4)+"...";
                        }
                        var unit = params.data.chartUnit;
                        var value = params.data.value;
                        var text = name + ":" + value + unit;
                        return text;
                    }
                }
            }
        ]
    };
    chartDiv.setOption(option);
    window.addEventListener("resize", function () {
        chartDiv.resize();
    });
    chartDiv.on('click', function (params) {
        var color  = params.color;
        var item_eles = params.data.element.item_eles;
        var elementId= params.data.element.elementId;
        var isEndNode = params.data.element.isEndNode;
        var resultData = params.data.element.resultData;
        var resultElement = params.data.resultElement;
        resultElement.color  = color;
        resultElement.allNum = params.data.value;
        var searchType = params.data.searchType;
        var searchText = params.name.split(":")[0];
        searchText = params.seriesName + "/" + searchText;
        var defaultElements = [];
        for(var i = 0;i < item_eles.length;i ++){
            var element = {
                tab_name : item_eles[i].tab_name,
                que_eles : item_eles[i].tab_eles
            };
            defaultElements.push(element);
        }
        if(searchType == "1"){
            loadCrossElements(elementId,resultData,defaultElements,params.data.value,searchText,resultElement,isEndNode);
        }else{
            if(isEndNode == "1"){
                $("#secondElementsDiv").css("display","none");
                $("#secondElements").html("");
                var chartType = params.data.resultElement.chartType;
                var isSearchAllInstitution = false;
                if(chartType == "2"){
                    isSearchAllInstitution = true;
                }
                loadBlockDiv(defaultElements,searchText,resultElement,isSearchAllInstitution);
            }else{
                loadSecondElements(elementId,resultData,defaultElements,params.data.value,searchText,resultElement);
            }
        }
    });

}

//查询二级元素
function loadSecondElements(elementId,resultData,allElement,allNum,searchText,resultElement){
    var dataUnit = resultElement.chartUnit;
    $("#blockDiv").css("display","none");
    $("#secondElementsDivText").html("<a href='#' style='color: white;cursor: pointer;'>"+ searchText + "（" + allNum + dataUnit + "）</a>");
    $("#secondElements").html("");
    $("#secondElementsDiv").css("display","");
    $("#secondElementsDivText").unbind("click");
    $("#secondElementsDivText").on("click",function(){
        openBlockElementList(allElement,resultElement,false);
    });

    var jsonStr = {
        elementId : elementId
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getSecondElementsList";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0"){
        var data = result.data;
        for(var i = 0;i < data.length;i ++){
            if(data[i].dataType == "2"){
                var childElementId = data[i].elementId;
                var isEndNode = data[i].isEndNode;
                var chartType = data[i].chartType;
                var dataUrl = data[i].dataUrl;
                var dataParams = data[i].dataParams;
                var resultParams = data[i].resultParams;
                var dataObj = JSON.parse(dataParams);
                var keyParam = "";
                for (var key in dataObj){
                    keyParam = key;
                    if(dataObj[key] == ""){
                        dataObj[key] = resultData;
                    }
                }
                var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
                var resultParamId = resultParams.split("||")[0];
                var resultParamName = resultParams.split("||")[1];
                if(loadDataResult instanceof Array){
                    var groupElements = [];
                    if(chartType == "1"){
                        $("#secondElementsDiv").css("display","none");
                        var seriesDataArray = [];
                        for(var j = 0;j < loadDataResult.length;j ++) {
                            var item_name = loadDataResult[j][resultParamName];
                            seriesDataArray.push(item_name);
                            var item_eles = JSON.parse(JSON.stringify(data[i].item_eles));
                            for(var k = 0;k < item_eles.length;k ++){
                                for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                                    if(item_eles[k].tab_eles[m].que_val == undefined
                                        || item_eles[k].tab_eles[m].que_val == ""){
                                        item_eles[k].tab_eles[m].que_val = loadDataResult[j][resultParamId];
                                    }
                                }
                            }
                            var seriesElement = {
                                item_name: item_name,
                                item_eles: item_eles
                            };
                            groupElements.push(seriesElement);
                            var defaultElements = [];
                            for (var k = 0; k < item_eles.length; k++) {
                                var element = {
                                    tab_name: item_eles[k].tab_name,
                                    que_eles: item_eles[k].tab_eles
                                };
                                defaultElements.push(element);
                            }
                        }
                        loadLastElementChart(groupElements,seriesDataArray,searchText,resultElement,false);
                    }else{
                        var defaultElement = addDefaultElement(resultElement,allElement,true);
                        var isSearchAllInstitution = false;
                        if(chartType == "2"){
                            isSearchAllInstitution = true;
                        }
                        //全部按钮
                        var html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadBlockDiv("+ JSON.stringify(allElement).replace(/"/g, '&quot;') +",'"+searchText+"/全部',"+ JSON.stringify(resultElement).replace(/"/g, '&quot;') +","+isSearchAllInstitution+");\">全部（"+allNum+"）</div>";
                        if(isEndNode != "1"){
                            html = "";
                        }
                        $("#secondElements").append(html);
                        for(var j = 0;j < loadDataResult.length;j ++){
                            var item_name = loadDataResult[j][resultParamName];
                            if(isSearchDepartment && !isSearchAllInstitution){
                                if(item_name.indexOf(userOpptName) == -1){
                                    continue;
                                }
                            }

                            var item_eles =  JSON.parse(JSON.stringify(data[i].item_eles));
                            //item_eles[0].tab_eles[0].que_val = loadDataResult[j][resultParamId];
                            for(var k = 0;k < item_eles.length;k ++){
                                for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                                    if(item_eles[k].tab_eles[m].que_val == undefined
                                        || item_eles[k].tab_eles[m].que_val == ""){
                                        item_eles[k].tab_eles[m].que_val = loadDataResult[j][resultParamId];
                                    }
                                }
                            }
                            var seriesElement = {
                                item_name : item_name,
                                item_eles : item_eles
                            };
                            groupElements.push(seriesElement);
                            var defaultElements = [];
                            for(var k = 0;k < item_eles.length;k ++){
                                var element = {
                                    tab_name : item_eles[k].tab_name,
                                    que_eles : item_eles[k].tab_eles
                                };
                                defaultElements.push(element);
                            }
                            var searchSecondText = searchText + "/" + item_name;
                            var html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadBlockDiv("+ JSON.stringify(defaultElements).replace(/"/g, '&quot;') +",'"+searchSecondText+"',"+ JSON.stringify(defaultElement).replace(/"/g, '&quot;') +","+isSearchAllInstitution+");\">"+item_name+"（<span id='"+item_name+"'>0</span>）</div>";
                            if(isEndNode != "1"){
                                html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadLastElementDiv('"+childElementId+"','"+loadDataResult[j][resultParamId]+"','"+searchSecondText+"',"+ JSON.stringify(defaultElement).replace(/"/g, '&quot;') +",false);\">"+item_name+"（<span id='"+item_name+"'>0</span>）</div>";
                            }
                            $("#secondElements").append(html);
                        }
                        loadTotalNum(groupElements,defaultElement);
                    }
                }
            }else{
                var chartType = data[i].chartType;
                var defaultElement = addDefaultElement(resultElement,allElement,true);
                var isSearchAllInstitution = false;
                if(chartType == "2"){
                    isSearchAllInstitution = true;
                }
                if(i == 0){
                    var html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadBlockDiv("+ JSON.stringify(allElement).replace(/"/g, '&quot;') +",'"+searchText+"/全部',"+ JSON.stringify(resultElement).replace(/"/g, '&quot;') +","+isSearchAllInstitution+");\">全部（"+allNum+"）</div>";
                    $("#secondElements").append(html);
                }
                var childElementId = data[i].elementId;
                var isEndNode = data[i].isEndNode;
                var defaultElements = [];
                var item_name = data[i].item_name;
                var item_eles = data[i].item_eles;
                for(var k = 0;k < item_eles.length;k ++){
                    var element = {
                        tab_name : item_eles[k].tab_name,
                        que_eles : item_eles[k].tab_eles
                    };
                    defaultElements.push(element);
                }
                var groupElement = [];
                groupElement.push(data[i]);
                var searchSecondText = searchText + "/" + item_name;
                var html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadBlockDiv("+ JSON.stringify(defaultElements).replace(/"/g, '&quot;') +",'"+searchSecondText+"',"+ JSON.stringify(resultElement).replace(/"/g, '&quot;') +","+isSearchAllInstitution+");\">"+item_name+"（<span id='"+item_name+"'>0</span>）</div>";
                $("#secondElements").append(html);
                loadTotalNum(groupElement,defaultElement);
            }
        }
    }
}

//读取最后一级查询元素
function loadLastElementDiv(elementId,resultData,searchText,resultElement,isCross){
    var jsonStr = {
        elementId : elementId
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getSecondElementsList";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0"){
        var data = result.data;
        for(var i = 0;i < data.length;i ++){
            if(data[i].dataType == "2"){
                var childElementId = data[i].elementId;
                var dataUrl = data[i].dataUrl;
                var dataParams = data[i].dataParams;
                var resultParams = data[i].resultParams;
                var dataObj = JSON.parse(dataParams);
                var keyParam = "";
                for (var key in dataObj){
                    keyParam = key;
                    if(dataObj[key] == ""){
                        dataObj[key] = resultData;
                    }
                }
                var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
                var resultParamId = resultParams.split("||")[0];
                var resultParamName = resultParams.split("||")[1];
                if(loadDataResult instanceof Array){
                    var groupElements = [];
                    var seriesDataArray = [];
                    for(var j = 0;j < loadDataResult.length;j ++) {
                        var item_name = loadDataResult[j][resultParamName];
                        seriesDataArray.push(item_name);
                        var item_eles = JSON.parse(JSON.stringify(data[i].item_eles));
                        for(var k = 0;k < item_eles.length;k ++){
                            for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                                if(item_eles[k].tab_eles[m].que_val == undefined
                                    || item_eles[k].tab_eles[m].que_val == ""){
                                    item_eles[k].tab_eles[m].que_val = loadDataResult[j][resultParamId];
                                }
                            }
                        }
                        var seriesElement = {
                            item_name: item_name,
                            item_eles: item_eles
                        };
                        groupElements.push(seriesElement);
                        var defaultElements = [];
                        for (var k = 0; k < item_eles.length; k++) {
                            var element = {
                                tab_name: item_eles[k].tab_name,
                                que_eles: item_eles[k].tab_eles
                            };
                            defaultElements.push(element);
                        }
                    }
                    loadLastElementChart(groupElements,seriesDataArray,searchText,resultElement,isCross);
                }
            }
        }
    }
}

function changeSecondElement(obj){
    $(".secondElements").each(function (index) {
        this.classList.remove("selected");
    });
    obj.classList.add("selected");
}

//读取总数
function loadTotalNum(groupElements,resultElement){
    var jsonStr = {
        //分组参数
        elements : []
        //聚和参数
        ,resultElementJson : resultElement
    };
    jsonStr.elements = groupElements;
    var url = contextPath + esUrl;
    if(esParams.indexType != ""){
        jsonStr.indexType = esParams.indexType;
    }
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code === "0") {
        var data = result.data;
        for(var i = 0;i < data.length;i ++) {
            var content = data[i].item_content;
            for(var j = 0;j < content.length;j ++){
                var id = content[j].key;
                document.getElementById(id).innerHTML = content[j].doc_count;
            }
        }
    }
}

//查询机构
var blockChart = null;
function loadBlockDiv(defaultElements,searchText,resultElement,isSearchAllInstitution){
    var secondElementsDiv = $("#secondElementsDiv");
    var allNum = resultElement.allNum;
    if(secondElementsDiv.css("display") != "none"){
        if($("#secondElements div.selected span").length > 0){
            allNum = $("#secondElements div.selected span")[0].innerHTML;
        }
    }
    var dataUnit = resultElement.chartUnit;
    $("#blockDiv").css("display","");
    $("#blockDivText").html("<a href='#' style='color: white;cursor: pointer;'>" + searchText+"/属地分布" + "（" + allNum + dataUnit + "）</a>");
    $("#blockDivText").unbind("click");
    $("#blockDivText").on("click",function(){
        openBlockElementList(defaultElements,resultElement,false);
    });
    var color = resultElement.color;
    var xTextArray = [];
    if(isSearchDepartment){
        var userJson = {
            unifiedSocialCreditCode: parent.userOpptId
        };
        var userUrl = contextPath + "/organization/institutional/findItInstitutions1ByOptType";
        var userData = loadingAjaxJsonData(userUrl, userJson);
        if (userData.code == "0") {
            if (userData.data > 0) {
                isSearchDepartment = false;
            }
        }
    }
    var groupElements = [];
    if(isSearchDepartment){
        //部门列表
        var departmentIdArray = [];
        var departmentNameArray = [];
        //查询部门
        var departmentAllList = [];
        var departmentJsonStr = {
            page: 1,
            limit: 100,
            elements: [
                {
                    tab_name: "institutions", //查询条件表 查询哪个表的条件 enterprise enterprise_inspection
                    que_eles: [
                        {
                            que_key : "UNIFIEDSOCIALCREDITCODE",
                            que_val : parent.userOpptId,
                            que_type : "3",
                            que_mode : "1"
                        }
                    ]
                }
            ],
            resultElements: {
                tab_relation: "",
                tab_parent: "institutions",
                tab_return: "department",
                tab_fields: "DEPARTMENTID,DEPARTMENTNAME",
                sort_field: "DPTSEQUENCE",
                sort_order: "ASC"
            }
        };
        var departmentUrl = contextPath + "/organization/institutional/esInstitutionsSearch";
        var departmentResult = loadingAjaxJsonData(departmentUrl, departmentJsonStr);
        if(departmentResult.code == "0"){
            departmentAllList = departmentResult.data;
        }

        var listChartName = "";
        for(var i = 0;i < departmentAllList.length;i ++){
            departmentIdArray.push(departmentAllList[i].DEPARTMENTID);
            var text = departmentAllList[i].DEPARTMENTNAME;
            xTextArray.push(text);
            if(resultElement.tab_parent == "enterprise"){
                if (resultElement.returnTabText == "许可证") {
                    listChartName = "许可证数量"
                }else {
                    listChartName = "企业数量"
                }
                var groupElement = {
                    item_name : departmentAllList[i].DEPARTMENTNAME,
                    item_eles : [{
                        tab_name : "enterprise",
                        tab_eles : [
                            {
                                que_key : "SUPERVISIONDPTNAME.DEPARTMENTID",
                                que_val : departmentAllList[i].DEPARTMENTID,
                                que_type : "6"
                            }
                        ]
                    }]
                };
                groupElements.push(groupElement);
            }else if(resultElement.tab_parent == "execution"){
                listChartName = "文书数量"
                var groupElement = {
                    item_name : departmentAllList[i].DEPARTMENTNAME,
                    item_eles : [{
                        tab_name : "execution",
                        tab_eles : [
                            {
                                que_key : "REPORTDEPTID",
                                que_val : departmentAllList[i].DEPARTMENTID,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                groupElements.push(groupElement);
            }else if(resultElement.tab_parent == "accident"){
                listChartName = "事故数量"
                var groupElement = {
                    item_name : departmentAllList[i].DEPARTMENTNAME,
                    item_eles : [{
                        tab_name : "accident",
                        tab_eles : [
                            {
                                que_key : "REPORTDEPTID",
                                que_val : departmentAllList[i].DEPARTMENTID,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                groupElements.push(groupElement);
            }
        }
    }else{
        //机构列表
        var opptIdArray = [];
        //查询机构
        var institutionsAllList = [];
        var opptJsonStr = {
            page: 1,
            limit: 100,
            elements: [
                {
                    tab_name: "institutions", //查询条件表 查询哪个表的条件 enterprise enterprise_inspection
                    que_eles: [
                        {
                            que_key : "OPTTYPE",
                            que_val : "4324",
                            que_type : "3",
                            que_mode : "3"
                        },{
                            que_key : "OPTTYPE",
                            que_val : "4325",
                            que_type : "3",
                            que_mode : "3"
                        }
                    ]
                }
            ],
            resultElements: {
                tab_relation: "",
                tab_parent: "institutions",
                tab_return: "institutions",
                tab_fields: "UNIFIEDSOCIALCREDITCODE,BILLTOP,REGULATORYAGENCYNAME",
                sort_field: "ORDERSEQUENCE",
                sort_order: "ASC"
            }
        };
        //是否查询安监局数据
        if(isSearchAllInstitution){
            var allInstitution = {
                que_key : "OPTTYPE",
                que_val : "4309",
                que_type : "3",
                que_mode : "3"
            };
            opptJsonStr.elements[0].que_eles.push(allInstitution);
        }
        var opptUrl = contextPath + "/organization/institutional/esInstitutionsSearch";
        var opptResult = loadingAjaxJsonData(opptUrl, opptJsonStr);
        if(opptResult.code == "0"){
            institutionsAllList = opptResult.data;
        }
        var listChartName = "";
        for(var i = 0;i < institutionsAllList.length;i ++){
            opptIdArray.push(institutionsAllList[i].UNIFIEDSOCIALCREDITCODE);
            var text = institutionsAllList[i].REGULATORYAGENCYNAME;
            xTextArray.push(text);
            if(resultElement.tab_parent == "enterprise"){
                if (resultElement.returnTabText == "许可证") {
                    listChartName = "许可证数量"
                }else {
                    listChartName = "企业数量"
                }
                var groupElement = {
                    item_name : institutionsAllList[i].REGULATORYAGENCYNAME,
                    item_eles : [{
                        tab_name : "enterprise",
                        tab_eles : [
                            {
                                que_key : "SUPERVISIONOPTNAME.OPPTID",
                                que_val : institutionsAllList[i].UNIFIEDSOCIALCREDITCODE,
                                que_type : "6"
                            }
                        ]
                    }]
                };
                groupElements.push(groupElement);
            }else if(resultElement.tab_parent == "execution"){
                listChartName = "文书数量"
                var groupElement = {
                    item_name : institutionsAllList[i].REGULATORYAGENCYNAME,
                    item_eles : [{
                        tab_name : "execution",
                        tab_eles : [
                            {
                                que_key : "REPORTOPPTID",
                                que_val : institutionsAllList[i].UNIFIEDSOCIALCREDITCODE,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                groupElements.push(groupElement);
            }else if(resultElement.tab_parent == "accident"){
                listChartName = "事故数量"
                var groupElement = {
                    item_name : institutionsAllList[i].REGULATORYAGENCYNAME,
                    item_eles : [{
                        tab_name : "accident",
                        tab_eles : [
                            {
                                que_key : "REPORTOPPTID",
                                que_val : institutionsAllList[i].UNIFIEDSOCIALCREDITCODE,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                groupElements.push(groupElement);
            }
        }
    }

    var contentArray = [];
    if(resultElement.tab_return == "enterprise" && (resultElement.tab_parent == "execution" || resultElement.tab_parent == "accident")){
        for(var i in defaultElements){
            var defaultElement = {
                tab_name : defaultElements[i].tab_name,
                tab_eles : defaultElements[i].que_eles
            };
            resultElement.agg_items[0].item_eles.push(defaultElement);
        }
        var returnArray = createEnterpriseGroupElements(groupElements,resultElement);
        for(var j = 0;j < groupElements.length;j ++){
            for(var i in returnArray){
                if(groupElements[j].item_name == returnArray[i].key){
                    var dataContent = {
                        name : returnArray[i].key,
                        value : returnArray[i].doc_count,
                        element : returnArray[i].element,
                        defaultElements : defaultElements,
                        returnTabText : resultElement.returnTabText,
                        returnTabUrl : resultElement.returnTabUrl
                    };
                    contentArray.push(dataContent);
                }
            }
        }
    }else{
        var returnElement = addDefaultElement(resultElement,defaultElements,false);
        var jsonStr = {
            //分组参数
            elements : []
            //聚和参数
            ,resultElementJson : returnElement
        };
        jsonStr.elements = groupElements;

        var url = contextPath + esUrl;
        if(esParams.indexType != ""){
            jsonStr.indexType = esParams.indexType;
        }
        var result = loadingAjaxJsonData(url, jsonStr);
        if(result.code === "0") {
            var data = result.data;
            for(var k = 0;k < data.length;k ++){
                var item_key = data[k].item_text;
                var content = data[k].item_content;
                for(var j = 0;j < groupElements.length;j ++){
                    for(var i = 0;i < content.length;i ++){
                        if(groupElements[j].item_name == content[i].key){
                            var element = makeUpElements(groupElements[j],resultElement);
                            var dataContent = {
                                name : content[i].key,
                                value : content[i].doc_count,
                                element : element,
                                defaultElements : defaultElements,
                                returnTabText : resultElement.returnTabText,
                                returnTabUrl : resultElement.returnTabUrl
                            };
                            contentArray.push(dataContent);
                        }
                    }
                }
            }
        }
    }

    var chartUnit = resultElement.chartUnit;
    if(blockChart != null){
        blockChart.clear();
        blockChart.dispose();
    }
    var blockDiv = echarts.init(document.getElementById("blockChartDiv"));
    blockChart = blockDiv;
    var option = {
        color: [color],
        legend: {

        },
        tooltip: {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {show: true},
                magicType: {show: true, type: ['line', 'bar']}
            }
        },
        grid: {
            left: '2%',
            right: '2%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data:xTextArray,
            gridIndex: 0,
            axisLabel: {
                interval: 0,
                rotate: 30,
                formatter: function (value, index) {
                    if(value.length > 4){
                        value = value.substr(0,4) + "...";
                    }
                    return value;
                }
            }
        }],
        yAxis: [{
            type: 'value',
            name: chartUnit,
            max: function(value) {
                if(value.max < 10){
                    return 10;
                }else{
                    return value.max;
                }
            },
            min:0,
            minInterval: 1
        }],
        series: [{
            name: listChartName,
            type: 'bar',
            //barMinHeight:1,
            barWidth: '30%',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
            data: contentArray
        }]
    };
    blockDiv.setOption(option);
    window.addEventListener("resize", function () {
        blockDiv.resize();
    });
    blockDiv.on('click', function (params) {
        tableUnitSearchElementArray = [];
        tableUnitSearchElementArray = JSON.parse(JSON.stringify(params.data.element));
        for(var i in params.data.defaultElements){
            var defaultElement = params.data.defaultElements[i];
            for(var j in tableUnitSearchElementArray){
                if(defaultElement.tab_name == tableUnitSearchElementArray[j].tab_name){
                    tableUnitSearchElementArray[j].que_eles = tableUnitSearchElementArray[j].que_eles.concat(defaultElement.que_eles);
                }else{
                    tableUnitSearchElementArray.push(defaultElement);
                }
            }
        }
        var returnTabText = params.data.returnTabText;
        var returnTabUrl = params.data.returnTabUrl;
        top.layer.open({
            type: 2,
            closeBtn: 1,
            btn: ['确定'],
            content: contextPath+'/enterprise/enterpriseEsSearch/'+returnTabUrl,
            title: [returnTabText, 'text-align:left'],
            area: ['80%', '80%'],
        });
    });
}

//读取最后元素图表
function loadLastElementChart(groupElements,seriesDataArray,searchText,resultElement,isCross){
    var dataUnit = resultElement.chartUnit;
    var allNum = resultElement.allNum;
    var secondElementsDiv = $("#secondElementsDiv");
    if(secondElementsDiv.css("display") != "none"){
        if($("#secondElements div.selected span").length > 0){
            allNum = $("#secondElements div.selected span")[0].innerHTML;
        }
    }
    $("#blockDiv").css("display","");
    $("#blockDivText").html("<a href='#' style='color:white;cursor: pointer;'>" + searchText+"/属地分布" + "（" + allNum + dataUnit + "）</a>");
    $("#blockDivText").unbind("click");
    $("#blockDivText").on("click",function(){
        openBlockElementList(groupElements,resultElement,isCross);
    });
    var color = resultElement.color;
    var jsonStr = {
        //分组参数
        elements : []
        //聚和参数
        ,resultElementJson : resultElement
    };
    jsonStr.elements = groupElements;
    var contentArray = [];
    if(isCross){
        var data = createEnterpriseGroupElements(groupElements,resultElement);
        for(var j = 0;j < groupElements.length;j ++){
            for(var i in data){
                if(groupElements[j].item_name == data[i].key){
                    var dataContent = {
                        name : data[i].key,
                        value : data[i].doc_count,
                        element : data[i].element,
                        returnTabText : resultElement.returnTabText,
                        returnTabUrl : resultElement.returnTabUrl
                    };
                    contentArray.push(dataContent);
                }
            }
        }
    }else{
        var url = contextPath + esUrl;
        if(esParams.indexType != ""){
            jsonStr.indexType = esParams.indexType;
        }
        var result = loadingAjaxJsonData(url, jsonStr);
        if(result.code === "0") {
            var data = result.data;
            for(var k = 0;k < data.length;k ++){
                var item_key = data[k].item_text;
                var content = data[k].item_content;
                for(var j = 0;j < groupElements.length;j ++){
                    for(var i = 0;i < content.length;i ++){
                        if(groupElements[j].item_name == content[i].key){
                            var element = makeUpElements(groupElements[j],resultElement);
                            var dataContent = {
                                name : content[i].key,
                                value : content[i].doc_count,
                                element : element,
                                returnTabText : resultElement.returnTabText,
                                returnTabUrl : resultElement.returnTabUrl
                            };
                            contentArray.push(dataContent);
                        }
                    }
                }
            }
        }
    }

    var chartUnit = resultElement.chartUnit;
    if(blockChart != null){
        blockChart.clear();
        blockChart.dispose();
    }
    var blockDiv = echarts.init(document.getElementById("blockChartDiv"));
    blockChart = blockDiv;
    var option = {
        color: [color],
        legend: {

        },
        tooltip: {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {show: true},
                magicType: {show: true, type: ['line', 'bar']}
            }
        },
        grid: {
            left: '2%',
            right: '2%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [{
            type: 'category',
            data:seriesDataArray,
            gridIndex: 0,
            axisLabel: {
                interval: 0,
                rotate: 30
            }
        }],
        yAxis: [{
            type: 'value',
            name: chartUnit,
            max: function(value) {
                if(value.max < 10){
                    return 10;
                }else{
                    return value.max;
                }
            },
            min:0,
            minInterval: 1
        }],
        series: [{
            name: '数量',
            type: 'bar',
            barWidth: '30%',
            stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
            data: contentArray
        }]
    };
    blockDiv.setOption(option);
    window.addEventListener("resize", function () {
        blockDiv.resize();
    });
    blockDiv.on('click', function (params) {
        tableUnitSearchElementArray = params.data.element;
        //tableUnitSearchElement = params.data.element;
        var returnTabUrl = params.data.returnTabUrl;
        var returnTabText = params.data.returnTabText;
        top.layer.open({
            type: 2,
            closeBtn: 1,
            btn: ['确定'],
            content: contextPath+'/enterprise/enterpriseEsSearch/'+returnTabUrl,
            title: [returnTabText, 'text-align:left'],
            area: ['80%', '80%'],
        });
    });
}

//组合分组条件和结果条件
function makeUpElements(groupElement,resultElement){
    var returnElement = [];
    for(var i in groupElement.item_eles) {
        var element = {
            tab_name : groupElement.item_eles[i].tab_name,
            que_eles : groupElement.item_eles[i].tab_eles
        };
        returnElement.push(element);
    }
    for(var i in resultElement.agg_items){
        var item_eles = resultElement.agg_items[i].item_eles;
        if(item_eles != undefined && item_eles != "" && item_eles.length > 0){
            for(var j in item_eles){
                var element = item_eles[j];
                var isExistTable = false;
                for(var k in returnElement){
                    if(returnElement[k].tab_name == element.tab_name){
                        isExistTable = true;
                        for(var m in element.que_eles){
                            returnElement[k].que_eles.push(element.que_eles[m]);
                        }
                        break;
                    }
                }
                if(!isExistTable){
                    returnElement.push(element);
                }
            }
        }
    }
    return returnElement;
}

function searhCrossData(chartsSeries,groupElements,searchElements){
    var dataArray = [];
    for(var j = 0;j < chartsSeries.length;j ++){
        var item_name = chartsSeries[j].item_name;
        var item_eles = chartsSeries[j].item_eles;
        var isEndNode = chartsSeries[j].isEndNode;
        var elementId = chartsSeries[j].elementId;
        var seriesElement = {
            item_name : item_name,
            isEndNode : isEndNode,
            elementId : elementId,
            item_eles : item_eles
        };
        if(chartsSeries[j].dataUrl != undefined && chartsSeries[j].dataUrl != ""){
            var dataUrl = chartsSeries[j].dataUrl;
            var dataParams = chartsSeries[j].dataParams;
            var resultParams = chartsSeries[j].resultParams;
            var dataObj = JSON.parse(dataParams);
            var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
            var resultParamId = resultParams.split("||")[0];
            var resultParamName = resultParams.split("||")[1];
            var queValue = "";
            if(loadDataResult instanceof Array){
                for(var k = 0;k < loadDataResult.length;k ++){
                    queValue += loadDataResult[k][resultParamId] + ",";
                }
                if(queValue != undefined && queValue != ""){
                    queValue = queValue.substr(0,queValue.length - 1);
                }
            }else{
                if(loadDataResult.code == "0"){
                    var loadDataResultData = loadDataResult.data;
                    for(var k = 0;k < loadDataResultData.length;k ++){
                        queValue += loadDataResultData[k][resultParamId] + ",";
                    }
                    if(queValue != undefined && queValue != ""){
                        queValue = queValue.substr(0,queValue.length - 1);
                    }
                }
            }
            seriesElement.resultData = queValue;
            for(var k = 0;k < item_eles.length;k ++){
                for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                    if(item_eles[k].tab_eles[m].que_val == undefined
                        || item_eles[k].tab_eles[m].que_val == ""){
                        item_eles[k].tab_eles[m].que_val = queValue;
                    }
                }
            }
            // if(extraDefaultElement != null){
            //     for(var i in extraDefaultElement[0].que_eles){
            //         searchElements.agg_items
            //         searchElements.push(extraDefaultElement[0].que_eles[i]);
            //     }
            // }
            groupElements.push(seriesElement);
        }
    }
    var returnTable = searchElements.agg_items[0].tab_return;
    if(returnTable == "enterprise"){
        for(var i in groupElements){
            var chartName = groupElements[i].item_name;
            var chartUnit = searchElements.chartUnit;
            var defaultElements = [];
            var otherElements = groupElements[i].item_eles[0].tab_eles;
            for(var j in otherElements){
                defaultElements.push(otherElements[j]);
            }
            var unitIdArray = searchEnterpriseCountData(defaultElements);
            if(unitIdArray != ""){
                searchElements.tab_parent = "enterprise";
                var jsonStr = {
                    //分组参数
                    elements : [{
                        item_name: "企业",
                        item_eles:[{
                            tab_name : "enterprise",
                            tab_eles : [{
                                que_key:"UNIFIEDSOCIALCREDITCODE",
                                que_val:unitIdArray,
                                que_type:"3",
                                que_mode:"1"
                            }]
                        }]
                    }]
                    //聚和参数
                    ,resultElementJson : searchElements
                };
                var enterpriseUrl = contextPath + "enterprise/enterpriseEsSearch/esEnterpriseAggregationSearch";
                var enterpriseResult = loadingAjaxJsonData(enterpriseUrl, jsonStr);
                if(enterpriseResult.code === "0") {
                    var enterpriseData = enterpriseResult.data;
                    var content = enterpriseData[0].item_content;
                    searchElements.tab_parent = "execution";
                    var dataContent = {
                        //name : chartName + ":" + content[0].doc_count + chartUnit,
                        name : chartName,
                        chartUnit : chartUnit,
                        value : content[0].doc_count,
                        element : groupElements[i],
                        resultElement : searchElements,
                        searchType : "1"
                    };
                    if(groupElements[i].seriesColor != undefined && groupElements[i].seriesColor != ""){
                        dataContent.itemStyle = {color : groupElements[i].seriesColor};
                    }
                    dataArray.push(dataContent);
                }
            }else{
                var dataContent = {
                    //name : chartName + ":" + 0 + chartUnit,
                    name : chartName,
                    chartUnit : chartUnit,
                    value : 0,
                    element : groupElements[i],
                    resultElement : searchElements,
                    searchType : "1"
                };
                if(groupElements[i].seriesColor != undefined && groupElements[i].seriesColor != ""){
                    dataContent.itemStyle = {color : groupElements[i].seriesColor};
                }
                dataArray.push(dataContent);
            }
        }
    }else if(returnTable == "execution"){

    }
    return dataArray;
}

//查询特殊条件
function loadCrossElements(elementId,resultData,allElement,allNum,searchText,resultElement,isEndNode){
    var dataUnit = resultElement.chartUnit;
    $("#blockDiv").css("display","none");
    $("#secondElementsDivText").html("<a href='#' style='color: white;cursor: pointer;'>" + searchText + "（" + allNum + dataUnit +"）</a>");
    $("#secondElementsDivText").unbind("click");
    $("#secondElementsDivText").on("click",function(){
        openBlockElementList(allElement,resultElement,true);
    });
    $("#secondElements").html("");
    $("#secondElementsDiv").css("display","");
    var jsonStr = {
        elementId : elementId
    };
    var url = contextPath + "enterprise/enterpriseEsSearch/getSecondElementsList";
    var result = loadingAjaxJsonData(url, jsonStr);
    if(result.code == "0") {
        var data = result.data;
        for (var i = 0; i < data.length; i++) {
            var childElementId = data[i].elementId;
            var isEndNode = data[i].isEndNode;
            var chartType = data[i].chartType;
            var dataUrl = data[i].dataUrl;
            var dataParams = data[i].dataParams;
            var resultParams = data[i].resultParams;
            var dataObj = JSON.parse(dataParams);
            var keyParam = "";
            for (var key in dataObj){
                keyParam = key;
                if(dataObj[key] == ""){
                    dataObj[key] = resultData;
                }
            }
            var loadDataResult = loadingAjaxJsonData(contextPath + dataUrl, dataObj);
            var resultParamId = resultParams.split("||")[0];
            var resultParamName = resultParams.split("||")[1];
            if(loadDataResult instanceof Array){
                var groupElements = [];
                if(chartType == "1"){
                    $("#secondElementsDiv").css("display","none");
                    var seriesDataArray = [];
                    for(var j = 0;j < loadDataResult.length;j ++) {
                        var item_name = loadDataResult[j][resultParamName];
                        seriesDataArray.push(item_name);
                        var item_eles = JSON.parse(JSON.stringify(data[i].item_eles));
                        for(var k = 0;k < item_eles.length;k ++){
                            for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                                if(item_eles[k].tab_eles[m].que_val == undefined
                                    || item_eles[k].tab_eles[m].que_val == ""){
                                    item_eles[k].tab_eles[m].que_val = loadDataResult[j][resultParamId];
                                }
                            }
                        }
                        var seriesElement = {
                            item_name: item_name,
                            item_eles: item_eles
                        };
                        groupElements.push(seriesElement);
                        var defaultElements = [];
                        for (var k = 0; k < item_eles.length; k++) {
                            var element = {
                                tab_name: item_eles[k].tab_name,
                                que_eles: item_eles[k].tab_eles
                            };
                            defaultElements.push(element);
                        }
                    }
                    loadLastElementChart(groupElements,seriesDataArray,searchText,resultElement,true);
                }else{
                    $("#secondElementsDiv").css("display","");
                    var isSearchAllInstitution = false;
                    if(chartType == "2"){
                        isSearchAllInstitution = true;
                    }
                    //全部按钮
                    var html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadBlockDiv("+ JSON.stringify(allElement).replace(/"/g, '&quot;') +",'"+searchText+"/全部',"+ JSON.stringify(resultElement).replace(/"/g, '&quot;') +","+isSearchAllInstitution+");\">全部（"+allNum+"）</div>";
                    if(isEndNode != "1"){
                        html = "";
                    }
                    $("#secondElements").append(html);
                    for(var j = 0;j < loadDataResult.length;j ++){
                        var item_name = loadDataResult[j][resultParamName];
                        if(isSearchDepartment){
                            if(item_name.indexOf(userOpptName) == -1){
                                continue;
                            }
                        }
                        var item_eles =  JSON.parse(JSON.stringify(data[i].item_eles));
                        for(var k = 0;k < item_eles.length;k ++){
                            for(var m = 0;m < item_eles[k].tab_eles.length;m ++){
                                if(item_eles[k].tab_eles[m].que_val == undefined
                                    || item_eles[k].tab_eles[m].que_val == ""){
                                    item_eles[k].tab_eles[m].que_val = loadDataResult[j][resultParamId];
                                }
                            }
                        }
                        var seriesElement = {
                            item_name : item_name,
                            item_eles : item_eles
                        };
                        groupElements.push(seriesElement);
                        var defaultElements = [];
                        for(var k = 0;k < item_eles.length;k ++){
                            var element = {
                                tab_name : item_eles[k].tab_name,
                                que_eles : item_eles[k].tab_eles
                            };
                            defaultElements.push(element);
                        }
                        var searchSecondText = searchText + "/" + item_name;
                        var html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadBlockDiv("+ JSON.stringify(defaultElements).replace(/"/g, '&quot;') +",'"+searchSecondText+"',"+ JSON.stringify(resultElement).replace(/"/g, '&quot;') +","+isSearchAllInstitution+");\">"+item_name+"（<span id='"+item_name+"'>0</span>）</div>";
                        if(isEndNode != "1"){
                            html = "<div class='secondElements' onclick=\"changeSecondElement(this);loadLastElementDiv('"+childElementId+"','"+loadDataResult[j][resultParamId]+"','"+searchSecondText+"',"+ JSON.stringify(resultElement).replace(/"/g, '&quot;') +",true);\">"+item_name+"（<span id='"+item_name+"'>0</span>）</div>";
                        }
                        $("#secondElements").append(html);
                    }
                    loadCrossNum(groupElements,resultElement);
                }
            }
        }
    }
}

//生成企业分组数量
function createEnterpriseGroupElements(groupElements,resultElement){
    var parentTab = resultElement.tab_parent;
    var returnField = "UNITID";
    if(parentTab == "accident"){
        returnField = "UNIFIEDSOCIALCREDITCODE";
    }
    var returnResultElement = {
        tab_relation : "",
        tab_parent : parentTab,
        tab_return : parentTab,
        tab_fields : returnField,
        sort_field : "",
        sort_order : ""
    };

    var jsonParam = {
        data : []
    };
    for(var i in groupElements){
        var item = groupElements[i].item_eles;
        var defaultElements = item[0].tab_eles;
        if(resultElement.agg_items[0].item_eles.length > 0){
            for(var j in resultElement.agg_items[0].item_eles){
                for(var k in resultElement.agg_items[0].item_eles[j].tab_eles){
                    defaultElements.push(resultElement.agg_items[0].item_eles[j].tab_eles[k]);
                }
            }
        }
        //var unitArray = searchEnterpriseCountData(defaultElements);
        var elements = [{
            tab_name : parentTab,
            que_eles : defaultElements
        }];
        if(extraDefaultElement != null){
            for(var j in extraDefaultElement[0].que_eles){
                defaultElements.push(extraDefaultElement[0].que_eles[j]);
            }
        }
        var executionResultElements = returnResultElement;
        var json = {
            groupName : groupElements[i].item_name,
            page : "1",
            limit : 10000,
            indexType : parentTab,
            elements : elements,
            resultElements : executionResultElements
        };
        jsonParam.data.push(json);
    }
    var url = contextPath + "execution/executionEsSearch/esExecutionSearchToEnterprise";
    var result = loadingAjaxJsonData(url, jsonParam);
    if(result.code == "0"){
        var groupArray = result.data;
        var groupCount = [];
        for(var i in groupArray){
            var unitParam = groupArray[i].unitId;
            if(unitParam == ""){
                unitParam = "0";
            }
            var groupParam = {
                item_name: groupArray[i].groupName,
                item_eles:[{
                    tab_name : "enterprise",
                    tab_eles : [{
                        que_key:"UNIFIEDSOCIALCREDITCODE",
                        que_val: unitParam,
                        que_type:"3",
                        que_mode:"1"
                    }]
                }]
            };
            groupCount.push(groupParam);
        }
        var enterpriseJsonStr = {
            //分组参数
            elements : groupCount
            //聚和参数
            ,resultElementJson : {
                tab_relation : "",
                tab_parent : "enterprise",
                agg_items : [{
                    item_text : "企业数量",
                    tab_return : "enterprise",
                    item_eles : []
                }]
            }
        };
        var enterpriseUrl = contextPath + "enterprise/enterpriseEsSearch/esEnterpriseAggregationSearch";
        var enterpriseResult = loadingAjaxJsonData(enterpriseUrl, enterpriseJsonStr);
        if(enterpriseResult.code == "0"){
            var enterpriseData = enterpriseResult.data[0];
            var content = enterpriseData.item_content;
            for(var i in content){
                for(var j in groupCount){
                    if(groupCount[j].item_name == content[i].key){
                        content[i].element = [{
                            tab_name : "enterprise",
                            que_eles : [{
                                que_key:"UNIFIEDSOCIALCREDITCODE",
                                que_val: groupCount[j].item_eles[0].tab_eles[0].que_val,
                                que_type:"3",
                                que_mode:"1"
                            }]
                        }];
                    }
                }
            }
            return content;
        }
    }
}

function loadCrossNum(groupElements,resultElement){
    var data = createEnterpriseGroupElements(groupElements,resultElement);
    for(var j = 0;j < data.length;j ++){
        var id = data[j].key;
        document.getElementById(id).innerHTML = data[j].doc_count;
    }
}


//查询企业数量
function searchEnterpriseCountData(defaultElements){
    var elements = [{
        tab_name : "execution",
        que_eles : defaultElements
    }];
    if(extraDefaultElement != null){
        for(var i in extraDefaultElement[0].que_eles){
            defaultElements.push(extraDefaultElement[0].que_eles[i]);
        }
    }
    var executionResultElements = {
        tab_relation : "",
        tab_parent : "execution",
        tab_return : "execution",
        tab_fields : "UNITID",
        sort_field : "",
        sort_order : ""
    };
    var jsonParam = {
        page : "1",
        limit : 10000,
        elements : elements,
        resultElements : executionResultElements
    };
    var url = contextPath + "execution/executionEsSearch/esExecutionSearch";
    var result = loadingAjaxJsonData(url, jsonParam);
    var data = result.data;
    var unitIdArray = "";
    for(var i in data){
        unitIdArray += data[i].UNITID + ",";
    }
    if(unitIdArray != ""){
        unitIdArray = unitIdArray.substr(0,unitIdArray.length-1);
    }
    return unitIdArray;
}


function addDefaultElement(resultElement,defaultElement,isDefault){
    var returnElement = JSON.parse(JSON.stringify(resultElement));
    var item = returnElement.agg_items[0].item_eles;
    if(item.length > 0){
        for(var i in item){
            for(var j in defaultElement){
                if(item[i].tab_name == defaultElement[j].tab_name){
                    for(var k in defaultElement[j].que_eles){
                        if(isDefault){
                            if(defaultElement[j].que_eles[k].isDefault == "1"){
                                item[i].que_eles.push(defaultElement[j].que_eles[k]);
                            }
                        }else{
                            item[i].que_eles.push(defaultElement[j].que_eles[k]);
                        }
                    }
                }else{
                    var newElement = {
                        tab_name : defaultElement[j].tab_name,
                        que_eles : []
                    };
                    for(var k in defaultElement[j].que_eles){
                        if(isDefault){
                            if(defaultElement[j].que_eles[k].isDefault == "1"){
                                newElement.que_eles.push(defaultElement[j].que_eles[k]);
                            }
                        }else{
                            newElement.que_eles.push(defaultElement[j].que_eles[k]);
                        }
                    }
                    item.push(newElement);
                }
            }
        }
    }else{
        for(var i in defaultElement){
            var newElement = {
                tab_name : defaultElement[i].tab_name,
                que_eles : []
            };
            for(var k in defaultElement[i].que_eles){
                if(isDefault){
                    if(defaultElement[i].que_eles[k].isDefault == "1"){
                        newElement.que_eles.push(defaultElement[i].que_eles[k]);
                    }
                }else{
                    newElement.que_eles.push(defaultElement[i].que_eles[k]);
                }
            }
            item.push(newElement);
        }
    }
    return returnElement;
}

//标题点击查询全部查询条件列表
function openAllElementList(obj,isCross){
    var index = obj.id.split("_")[1];
    var groupElements = JSON.parse($("#chartGroupElement_"+index).val());
    var searchElements = JSON.parse($("#chartResultElement_"+index).val());
    var returnTabUrl = searchElements.returnTabUrl;
    var returnTabText = searchElements.returnTabText;
    var tableSearchElementArray = [];
    for(var i in groupElements){
        var item = groupElements[i].item_eles;
        for(var j in item){
            var itemObj = item[j];
            if(tableSearchElementArray.length > 0){
                for(var k in tableSearchElementArray){
                    var key = tableSearchElementArray[k].tab_name;
                    if(key == itemObj.tab_name){
                        judgeExistSameKey(tableSearchElementArray[k].que_eles,itemObj.tab_eles);
                    }
                }
            }else{
                var itemObjEles = null;
                if(itemObj.tab_eles != undefined){
                    itemObjEles = itemObj.tab_eles;
                }else if(itemObj.tab_eles != undefined){
                    itemObjEles = itemObj.que_eles;
                }
                var searchElement = {
                    tab_name : itemObj.tab_name,
                    que_eles : itemObjEles
                };
                tableSearchElementArray.push(searchElement);
            }
        }
    }
    for(var i in searchElements.agg_items[0].item_eles){
        var item = searchElements.agg_items[0].item_eles[i];
        var tab_name = item.tab_name;
        var isExist = false;
        for(var j in tableSearchElementArray){
            var key = tableSearchElementArray[j].tab_name;
            if(key == tab_name){
                tableSearchElementArray[j].que_eles = tableSearchElementArray[j].que_eles.concat(item.que_eles);
                isExist = true;
                break;
            }
        }
        if(!isExist){
            tableSearchElementArray.push(item);
        }
    }
    if(isCross){
        tableUnitSearchElementArray = recombineCrossElements(tableSearchElementArray,searchElements);
    }else{
        tableUnitSearchElementArray = tableSearchElementArray;
    }
    top.layer.open({
        type: 2,
        closeBtn: 1,
        btn: ['确定'],
        content: contextPath+'/enterprise/enterpriseEsSearch/'+returnTabUrl,
        title: [returnTabText, 'text-align:left'],
        area: ['80%', '80%'],
    });
}

//所属监管单位点击标题查询全部
function openBlockElementList(groupElements,searchElements,isCross){
    var returnTabUrl = searchElements.returnTabUrl;
    var returnTabText = searchElements.returnTabText;
    var tableSearchElementArray = [];
    for(var i in groupElements){
        var item = groupElements[i];
        if(item.item_eles != undefined){
            item = groupElements[i].item_eles;
            for(var j in item){
                var itemObj = item[j];
                if(tableSearchElementArray.length > 0){
                    for(var k in tableSearchElementArray){
                        var key = tableSearchElementArray[k].tab_name;
                        if(key == itemObj.tab_name){
                            judgeExistSameKey(tableSearchElementArray[k].que_eles,itemObj.tab_eles);
                        }
                    }
                }else{
                    var itemObjEles = null;
                    if(itemObj.tab_eles != undefined){
                        itemObjEles = itemObj.tab_eles;
                    }else if(itemObj.tab_eles != undefined){
                        itemObjEles = itemObj.que_eles;
                    }
                    var searchElement = {
                        tab_name : itemObj.tab_name,
                        que_eles : itemObjEles
                    };
                    tableSearchElementArray.push(searchElement);
                }
            }
        }else{
            if(tableSearchElementArray.length > 0){
                for(var j in tableSearchElementArray){
                    var key = tableSearchElementArray[j].tab_name;
                    if(key == item.tab_name){
                        judgeExistSameKey(tableSearchElementArray[j].que_eles,item.tab_eles);
                    }
                }
            }else{
                var itemObjEles = null;
                if(item.tab_eles != undefined){
                    itemObjEles = item.tab_eles;
                }else if(item.que_eles != undefined){
                    itemObjEles = item.que_eles;
                }
                var searchElement = {
                    tab_name : item.tab_name,
                    que_eles : itemObjEles
                };
                tableSearchElementArray.push(searchElement);
            }
        }
    }
    for(var i in searchElements.agg_items[0].item_eles){
        var item = searchElements.agg_items[0].item_eles[i];
        var tab_name = item.tab_name;
        var isExist = false;
        for(var j in tableSearchElementArray){
            var key = tableSearchElementArray[j].tab_name;
            if(key == tab_name){
                tableSearchElementArray[j].que_eles = tableSearchElementArray[j].que_eles.concat(item.que_eles);
                isExist = true;
                break;
            }
        }
        if(!isExist){
            tableSearchElementArray.push(item);
        }
    }
    if(isCross){
        tableUnitSearchElementArray = recombineCrossElements(tableSearchElementArray,searchElements);
    }else{
        tableUnitSearchElementArray = tableSearchElementArray;
    }
    top.layer.open({
        type: 2,
        closeBtn: 1,
        btn: ['确定'],
        content: contextPath+'/enterprise/enterpriseEsSearch/'+returnTabUrl,
        title: [returnTabText, 'text-align:left'],
        area: ['80%', '80%'],
    });
}

//判断是否存在相同查询条件
function judgeExistSameKey(orginElement,otherElement){
    for(var i in otherElement){
        var isExist = false;
        var otherKey = otherElement[i].que_key;
        for(var j in orginElement){
            var key = orginElement[j].que_key;
            if(key == otherKey){
                isExist = true;
                if(orginElement[j].que_type == "6"){
                    orginElement[j].que_val += "," + otherElement[i].que_val;
                }else{
                    orginElement[j].que_mode = "3";
                    otherElement[i].que_mode = "3";
                    if(orginElement[j].que_val ==  otherElement[i].que_val){
                        orginElement[j].que_mode = "1";
                        otherElement[i].que_mode = "1";
                        break;
                    }
                    orginElement.push(otherElement[i]);
                }
                break;
            }
        }
        if(!isExist){
            orginElement.push(otherElement[i]);
        }
    }
}

//跨索引查询条件
function recombineCrossElements(tableSearchElementArray,searchElements){
    var crossElementsArray = [];
    var returnTable = searchElements.agg_items[0].tab_return;
    var parentTable = searchElements.tab_parent;
    if(returnTable == "enterprise"){
        var elements = tableSearchElementArray[0].que_eles;
        var unitArray = searchEnterpriseCountData(elements);
        var crossElements = {
            tab_name : "enterprise",
            que_eles : [{
                que_key:"UNIFIEDSOCIALCREDITCODE",
                que_val:unitArray,
                que_type:"3",
                que_mode:"1"
            }]
        };
        crossElementsArray.push(crossElements);
    }
    return crossElementsArray;
}

//点击标题加载全部元素属地分布
function loadAllBlockDiv(obj,isCross){
    var searchText = obj.innerHTML;
    var index = obj.id.split("_")[1];
    var groupElements = JSON.parse($("#chartGroupElement_"+index).val());
    var searchElements = JSON.parse($("#chartResultElement_"+index).val());
    var returnTabUrl = searchElements.returnTabUrl;
    var returnTabText = searchElements.returnTabText;
    $("#blockDiv").css("display","");
    $("#blockDivText").html(searchText + "/属地分布");


    var blockSeriesArray = [];
    for(var i in groupElements){

    }

    //组装x轴数据
    var isSearchAllInstitution = false;
    if(searchElements.chartType == "2"){
        isSearchAllInstitution = true;
    }
    var xElementArray = [];
    var xTextArray = [];
    if(isSearchDepartment){
        var userJson = {
            unifiedSocialCreditCode: parent.userOpptId
        };
        var userUrl = contextPath + "/organization/institutional/findItInstitutions1ByOptType";
        var userData = loadingAjaxJsonData(userUrl, userJson);
        if (userData.code == "0") {
            if (userData.data > 0) {
                isSearchDepartment = false;
            }
        }
    }
    if(isSearchDepartment){
        //部门列表
        var departmentIdArray = [];
        var departmentNameArray = [];
        //查询部门
        var departmentAllList = [];
        var departmentJsonStr = {
            page: 1,
            limit: 100,
            elements: [
                {
                    tab_name: "institutions", //查询条件表 查询哪个表的条件 enterprise enterprise_inspection
                    que_eles: [
                        {
                            que_key : "UNIFIEDSOCIALCREDITCODE",
                            que_val : parent.userOpptId,
                            que_type : "3",
                            que_mode : "1"
                        }
                    ]
                }
            ],
            resultElements: {
                tab_relation: "",
                tab_parent: "institutions",
                tab_return: "department",
                tab_fields: "DEPARTMENTID,DEPARTMENTNAME",
                sort_field: "DPTSEQUENCE",
                sort_order: "ASC"
            }
        };
        var departmentUrl = contextPath + "/organization/institutional/esInstitutionsSearch";
        var departmentResult = loadingAjaxJsonData(departmentUrl, departmentJsonStr);
        if(departmentResult.code == "0"){
            departmentAllList = departmentResult.data;
        }
        var listChartName = "";
        for(var i = 0;i < departmentAllList.length;i ++){
            departmentIdArray.push(departmentAllList[i].DEPARTMENTID);
            var text = departmentAllList[i].DEPARTMENTNAME;
            xTextArray.push(text);
            if(searchElements.tab_parent == "enterprise"){
                if (searchElements.returnTabText == "许可证") {
                    listChartName = "许可证数量"
                }else {
                    listChartName = "企业数量"
                }
                var groupElement = {
                    item_name : departmentAllList[i].DEPARTMENTNAME,
                    item_eles : [{
                        tab_name : "enterprise",
                        tab_eles : [
                            {
                                que_key : "SUPERVISIONDPTNAME.DEPARTMENTID",
                                que_val : departmentAllList[i].DEPARTMENTID,
                                que_type : "6"
                            }
                        ]
                    }]
                };
                xElementArray.push(groupElement);
            }else if(searchElements.tab_parent == "execution"){
                listChartName = "文书数量"
                var groupElement = {
                    item_name : departmentAllList[i].DEPARTMENTNAME,
                    item_eles : [{
                        tab_name : "execution",
                        tab_eles : [
                            {
                                que_key : "REPORTDEPTID",
                                que_val : departmentAllList[i].DEPARTMENTID,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                xElementArray.push(groupElement);
            }else if(searchElements.tab_parent == "accident"){
                listChartName = "事故数量"
                var groupElement = {
                    item_name : departmentAllList[i].DEPARTMENTNAME,
                    item_eles : [{
                        tab_name : "accident",
                        tab_eles : [
                            {
                                que_key : "REPORTDEPTID",
                                que_val : departmentAllList[i].DEPARTMENTID,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                xElementArray.push(groupElement);
            }
        }
    }else{
        //机构列表
        var opptIdArray = [];
        //查询机构
        var institutionsAllList = [];
        var opptJsonStr = {
            page: 1,
            limit: 100,
            elements: [
                {
                    tab_name: "institutions", //查询条件表 查询哪个表的条件 enterprise enterprise_inspection
                    que_eles: [
                        {
                            que_key : "OPTTYPE",
                            que_val : "4324",
                            que_type : "3",
                            que_mode : "3"
                        },{
                            que_key : "OPTTYPE",
                            que_val : "4325",
                            que_type : "3",
                            que_mode : "3"
                        }
                    ]
                }
            ],
            resultElements: {
                tab_relation: "",
                tab_parent: "institutions",
                tab_return: "institutions",
                tab_fields: "UNIFIEDSOCIALCREDITCODE,BILLTOP,REGULATORYAGENCYNAME",
                sort_field: "ORDERSEQUENCE",
                sort_order: "ASC"
            }
        };
        //是否查询安监局数据
        if(isSearchAllInstitution){
            var allInstitution = {
                que_key : "OPTTYPE",
                que_val : "4309",
                que_type : "3",
                que_mode : "3"
            };
            opptJsonStr.elements[0].que_eles.push(allInstitution);
        }
        var opptUrl = contextPath + "/organization/institutional/esInstitutionsSearch";
        var opptResult = loadingAjaxJsonData(opptUrl, opptJsonStr);
        if(opptResult.code == "0"){
            institutionsAllList = opptResult.data;
        }
        var listChartName = "";
        for(var i = 0;i < institutionsAllList.length;i ++){
            opptIdArray.push(institutionsAllList[i].UNIFIEDSOCIALCREDITCODE);
            var text = institutionsAllList[i].REGULATORYAGENCYNAME;
            xTextArray.push(text);
            if(searchElements.tab_parent == "enterprise"){
                if (searchElements.returnTabText == "许可证") {
                    listChartName = "许可证数量"
                }else {
                    listChartName = "企业数量"
                }
                var groupElement = {
                    item_name : institutionsAllList[i].REGULATORYAGENCYNAME,
                    item_eles : [{
                        tab_name : "enterprise",
                        tab_eles : [
                            {
                                que_key : "SUPERVISIONOPTNAME.OPPTID",
                                que_val : institutionsAllList[i].UNIFIEDSOCIALCREDITCODE,
                                que_type : "6"
                            }
                        ]
                    }]
                };
                xElementArray.push(groupElement);
            }else if(searchElements.tab_parent == "execution"){
                listChartName = "文书数量"
                var groupElement = {
                    item_name : institutionsAllList[i].REGULATORYAGENCYNAME,
                    item_eles : [{
                        tab_name : "execution",
                        tab_eles : [
                            {
                                que_key : "REPORTOPPTID",
                                que_val : institutionsAllList[i].UNIFIEDSOCIALCREDITCODE,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                xElementArray.push(groupElement);
            }else if(searchElements.tab_parent == "accident"){
                listChartName = "事故数量"
                var groupElement = {
                    item_name : institutionsAllList[i].REGULATORYAGENCYNAME,
                    item_eles : [{
                        tab_name : "accident",
                        tab_eles : [
                            {
                                que_key : "REPORTOPPTID",
                                que_val : institutionsAllList[i].UNIFIEDSOCIALCREDITCODE,
                                que_type : "3"
                            }
                        ]
                    }]
                };
                xElementArray.push(groupElement);
            }
        }
    }

    var defaultElements = null;
    var contentArray = [];
    if(searchElements.tab_return == "enterprise" && (searchElements.tab_parent == "execution" || searchElements.tab_parent == "accident")){
        // for(var i in defaultElements){
        //     var defaultElement = {
        //         tab_name : defaultElements[i].tab_name,
        //         tab_eles : defaultElements[i].que_eles
        //     };
        //     searchElements.agg_items[0].item_eles.push(defaultElement);
        // }
        var returnArray = createEnterpriseGroupElements(xElementArray,searchElements);
        for(var j = 0;j < xElementArray.length;j ++){
            for(var i in returnArray){
                if(xElementArray[j].item_name == returnArray[i].key){
                    var dataContent = {
                        name : returnArray[i].key,
                        value : returnArray[i].doc_count,
                        element : returnArray[i].element,
                        //defaultElements : defaultElements,
                        returnTabText : searchElements.returnTabText,
                        returnTabUrl : searchElements.returnTabUrl
                    };
                    contentArray.push(dataContent);
                }
            }
        }
    }else{
        //var returnElement = addDefaultElement(searchElements,defaultElements,false);
        var returnElement = JSON.parse(JSON.stringify(searchElements));
        var jsonStr = {
            //分组参数
            elements : []
            //聚和参数
            ,resultElementJson : returnElement
        };
        jsonStr.elements = xElementArray;

        var url = contextPath + esUrl;
        if(esParams.indexType != ""){
            jsonStr.indexType = esParams.indexType;
        }
        var result = loadingAjaxJsonData(url, jsonStr);
        if(result.code === "0") {
            var data = result.data;
            for(var k = 0;k < data.length;k ++){
                var item_key = data[k].item_text;
                var content = data[k].item_content;
                for(var j = 0;j < xElementArray.length;j ++){
                    for(var i = 0;i < content.length;i ++){
                        if(xElementArray[j].item_name == content[i].key){
                            var element = makeUpElements(xElementArray[j],searchElements);
                            var dataContent = {
                                name : content[i].key,
                                value : content[i].doc_count,
                                element : element,
                                defaultElements : defaultElements,
                                returnTabText : searchElements.returnTabText,
                                returnTabUrl : searchElements.returnTabUrl
                            };
                            contentArray.push(dataContent);
                        }
                    }
                }
            }
        }
    }
}

