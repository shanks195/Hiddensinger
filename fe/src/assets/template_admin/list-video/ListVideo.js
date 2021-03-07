import {PATH} from "../../../index/index.js"
function getListVideo(page, limit) {
    var list = {};
    let url = '';
    if (page || limit) {
        url = `${PATH}api/video/list?page=${page}&&limit=${limit}`
    } else {
        url = `${PATH}api/video/list`
    }
    const request = new Request(url, {
        method: 'GET',
        headers: new Headers({
            'Content-Type': 'application/json'
        }),
    });
    var rq = function () {
        fetch(request)
            .then(function (response) {
                return response.json();
            })
            .then(function (response) {
                list.listResult = response.listResult;
                list.page = response.page;
                list.totalPage = response.totalPage;
            })
            .catch(function (error) {

            });
    }();
    return list;
}

function getArrPageAble(page, limit, arr) {
    let arrNew = [];
    if (arr) {
        let arrLength = arr.length;
        let totalPage = Math.ceil(arrLength / limit);
        let onePage = page * limit;
        if (onePage > arrLength) {
            onePage = arrLength;
        }
        if (page <= totalPage) {
            for (let i = (page - 1) * limit; i < onePage; i++) {
                arrNew.push(arr[i]);
            }
        }
    }


    return arrNew;
}

function searchByNameVideo(name, arrVideoPage, arrVideoAll) {
    if (name&&arrVideoAll) {
        return arrVideoAll.filter(function (item) {
            return item.name.toLowerCase().search(name.toLowerCase()) == -1 ? false : true;
        });
    } else {
        return arrVideoPage;
    }
}


export { getListVideo, getArrPageAble, searchByNameVideo };