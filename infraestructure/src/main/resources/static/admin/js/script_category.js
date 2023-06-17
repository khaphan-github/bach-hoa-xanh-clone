const rootCategorySelected = localStorage.getItem('rootCategorySelected');
const parentCategorySelected = localStorage.getItem('parentCategorySelected');

let data_submit;
let rootCategoryId;
let parentCategoryId;



// Get the file csv1 input element
const fileInput = document.getElementById('formFileCsv');

// Add an event listener to the file input element
if (fileInput) {
    fileInput.addEventListener('change', handleFileUpload);
} else {
    console.error("File input element not found!");
}


// Get the file csv2 input element
const fileInput2 = document.getElementById('formFileCsv2');

// Add an event listener to the file input element
if (fileInput2) {
    fileInput2.addEventListener('change', handleFileUpload2);
} else {
    console.error("File input element not found!");
}


const fileInput3 = document.getElementById('formFileCsv3');

// Add an event listener to the file input element
if (fileInput3) {
    fileInput3.addEventListener('change', handleFileUpload3);
} else {
    console.error("File input element not found!");
}

// Function to handle the file upload
async function handleFileUpload(event) {
    if (event.target && event.target.files.length > 0) {
        const file = event.target.files[0]; // Get the selected file
        let mainSheetData;
        if (file) {
            // Read the file contents
            const reader = new FileReader();

            reader.onload = function (e) {
                const data = new Uint8Array(e.target.result);
                const workbook = XLSX.read(data, { type: 'array' });

                // Get the first sheet name
                const sheetName = workbook.SheetNames[0];

                // Get the worksheet by name
                const worksheet = workbook.Sheets[sheetName];

                // Convert worksheet to JSON
                const jsonData = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
                var header = jsonData[0];
                // Remove the header row from the JSON data
                jsonData.shift();

                // Convert JSON data to an array of objects with field names
                var jsonArray = [];
                jsonData.forEach(function (row) {
                    var obj = {};
                    row.forEach(function (cell, index) {
                        var headerField = header[index];
                        if (headerField === "name" || headerField === "href" || headerField === "keywords") {
                            obj[headerField] = cell;
                        }
                    });
                    jsonArray.push(obj);
                });




                // Save the data in a variable or use it as needed
                mainSheetData = jsonArray;
                console.log(mainSheetData)
                appendTableDisplayCsv(mainSheetData);

            };

            await reader.readAsArrayBuffer(file);
        }


    }

}

async function handleFileUpload2(event) {
    if (event.target && event.target.files.length > 0) {
        const file = event.target.files[0]; // Get the selected file
        let mainSheetData;
        if (file) {
            // Read the file contents
            const reader = new FileReader();

            reader.onload = function (e) {
                const data = new Uint8Array(e.target.result);
                const workbook = XLSX.read(data, { type: 'array' });

                // Get the first sheet name
                const sheetName = workbook.SheetNames[0];

                // Get the worksheet by name
                const worksheet = workbook.Sheets[sheetName];

                // Convert worksheet to JSON
                const jsonData = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
                var header = jsonData[0];
                // Remove the header row from the JSON data
                jsonData.shift();

                // Convert JSON data to an array of objects with field names
                var jsonArray = [];
                jsonData.forEach(function (row) {
                    var obj = {};
                    row.forEach(function (cell, index) {
                        var headerField = header[index];
                        if (headerField === "name" || headerField === "href" || headerField === "keywords") {
                            obj[headerField] = cell;
                        }
                    });
                    obj['parentId'] = rootCategoryId;
                    jsonArray.push(obj);
                });




                // Save the data in a variable or use it as needed
                mainSheetData = jsonArray;
                console.log(mainSheetData)
                appendTableDisplayCsv2(mainSheetData);

            };

            await reader.readAsArrayBuffer(file);
        }


    }

}


async function handleFileUpload3(event) {
    if (event.target && event.target.files.length > 0) {
        const file = event.target.files[0]; // Get the selected file
        let mainSheetData;
        if (file) {
            // Read the file contents
            const reader = new FileReader();

            reader.onload = function (e) {
                const data = new Uint8Array(e.target.result);
                const workbook = XLSX.read(data, { type: 'array' });

                // Get the first sheet name
                const sheetName = workbook.SheetNames[0];

                // Get the worksheet by name
                const worksheet = workbook.Sheets[sheetName];

                // Convert worksheet to JSON
                const jsonData = XLSX.utils.sheet_to_json(worksheet, { header: 1 });
                var header = jsonData[0];
                // Remove the header row from the JSON data
                jsonData.shift();

                // Convert JSON data to an array of objects with field names
                var jsonArray = [];
                jsonData.forEach(function (row) {
                    var obj = {};
                    row.forEach(function (cell, index) {
                        var headerField = header[index];
                        if (headerField === "name" || headerField === "href" || headerField === "keywords") {
                            obj[headerField] = cell;
                        }
                    });
                    obj['parentId'] = parentCategoryId;
                    jsonArray.push(obj);
                });




                // Save the data in a variable or use it as needed
                mainSheetData = jsonArray;
                console.log(mainSheetData)
                appendTableDisplayCsv3(mainSheetData);

            };

            await reader.readAsArrayBuffer(file);
        }


    }

}

async function appendTableDisplayCsv(mainSheetData){

    const data = mainSheetData;
    data_submit = JSON.stringify(data);
    console.log(data_submit)
        // Append the HTML code to the table-csv-display div
        var tableDisplayDiv = document.getElementById('table-csv-display');
        var html = `
                    <div class="table-responsive text-nowrap">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Href</th>
                                    <th>Keywords</th>
                                </tr>
                            </thead>
                            <tbody>         
                                ${data.slice(0,10).map(item => `
                                    <tr>
                                        <td>
                                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.name}</strong>
                                        </td>
                                        <td>${item.href}</td>
                                        <td><span class="badge bg-label-primary me-1">${item.keywords}</span></td>
                                    </tr>
                                `).join('')}
                            </tbody>
                        </table>
                    </div>
                `;
        tableDisplayDiv.innerHTML = html;

        const modalFooter = document.getElementById('modal-footer-csv');
        var html2= `
                        <button type="button" id="btn-cancel-csv" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                            Huỷ
                        </button>
                        <button type="submit" id="btn-submit-csv" onclick="uploadingCsv()"  class="btn btn-primary">Lưu</button>
                        
                        <div id="spinner-submit-csv" class="visually-hidden spinner-border spinner-border-sm text-secondary" role="status">
                        
                        </div>
        `;
    console.log(typeof data_submit);
    modalFooter.innerHTML = html2;


}

async function appendTableDisplayCsv2(mainSheetData){

    const data = mainSheetData;
    data_submit = JSON.stringify(data);
    console.log(data_submit)
    // Append the HTML code to the table-csv-display div
    var tableDisplayDiv = document.getElementById('table-csv-display2');
    var html = `
                    <div class="table-responsive text-nowrap">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Parent Id</th>
                                    <th>Name</th>
                                    <th>Href</th>
                                    <th>Keywords</th>
                                </tr>
                            </thead>
                            <tbody>         
                                ${data.slice(0,10).map(item => `
                                    <tr>
                                        <td>
                                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.parentId}</strong>
                                        </td>
                                        <td>
                                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.name}</strong>
                                        </td>
                                        <td>${item.href}</td>
                                        <td><span class="badge bg-label-primary me-1">${item.keywords}</span></td>
                                    </tr>
                                `).join('')}
                            </tbody>
                        </table>
                    </div>
                `;
    tableDisplayDiv.innerHTML = html;

    const modalFooter = document.getElementById('modal-footer-csv2');
    var html2= `
                        <button type="button" id="btn-cancel-csv" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                            Huỷ
                        </button>
                        <button type="submit" id="btn-submit-csv" onclick="uploadingCsv()"  class="btn btn-primary">Lưu</button>
                        
                        <div id="spinner-submit-csv" class="visually-hidden spinner-border spinner-border-sm text-secondary" role="status">
                        
                        </div>
        `;
    console.log(typeof data_submit);
    modalFooter.innerHTML = html2;


}

async function appendTableDisplayCsv3(mainSheetData){

    const data = mainSheetData;
    data_submit = JSON.stringify(data);
    console.log(data_submit)
    // Append the HTML code to the table-csv-display div
    var tableDisplayDiv = document.getElementById('table-csv-display3');
    var html = `
                    <div class="table-responsive text-nowrap">
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Parent Id</th>
                                    <th>Name</th>
                                    <th>Href</th>
                                    <th>Keywords</th>
                                </tr>
                            </thead>
                            <tbody>         
                                ${data.slice(0,10).map(item => `
                                    <tr>
                                        <td>
                                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.parentId}</strong>
                                        </td>
                                        <td>
                                            <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>${item.name}</strong>
                                        </td>
                                        <td>${item.href}</td>
                                        <td><span class="badge bg-label-primary me-1">${item.keywords}</span></td>
                                    </tr>
                                `).join('')}
                            </tbody>
                        </table>
                    </div>
                `;
    tableDisplayDiv.innerHTML = html;

    const modalFooter = document.getElementById('modal-footer-csv3');
    var html2= `
                        <button type="button" id="btn-cancel-csv" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                            Huỷ
                        </button>
                        <button type="submit" id="btn-submit-csv" onclick="uploadingCsv()"  class="btn btn-primary">Lưu</button>
                        
                        <div id="spinner-submit-csv" class="visually-hidden spinner-border spinner-border-sm text-secondary" role="status">
                        
                        </div>
        `;
    console.log(typeof data_submit);
    modalFooter.innerHTML = html2;


}

async function uploadingCsv() {

    const parsedData = JSON.parse(data_submit);

    const url = '/admin/category/api/uploadCategory';
    const requestBody = data_submit;
    showLoadingIndicator();
   await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: requestBody,
    })
        .then(response => response.json())
        .then(data => {
            // Handle the response data
            console.log('Response:', data);
            if(data.length !== 0)
            {

                Swal.fire({
                    title: 'Thành công',
                    text: 'Tải lên thành công, có ' +data.length.toString()+' sản phẩm tải lên thất bại',
                    icon: 'success',
                    confirmButtonText: 'Ok',
                    didClose: () => {
                        window.location.reload();
                    }
                })
            }
            else if(data.length === 0)
                Swal.fire({
                    title: 'Thành công',
                    text: 'Tải lên thành công toàn bộ',
                    icon: 'success',
                    confirmButtonText: 'Ok',
                    didClose: () => {
                        window.location.reload();
                    }
                })
        })
        .catch(error => {
            // Handle any errors
            console.error('Error:', error);
            alert("Loi roi");
        });
    hideLoadingIndicator();

}
function showLoadingIndicator() {
    // Show loading indicator logic
    // You can display a spinner or any other visual indication of loading
    // For example, adding a CSS class to show the loading spinner
    document.getElementById('spinner-submit-csv').classList.remove('visually-hidden');
    document.getElementById('btn-submit-csv').classList.add('visually-hidden');
}
async function hideLoadingIndicator() {
    // Hide loading indicator logic
    // You can hide the spinner or remove the visual indication of loading
    // For example, removing the CSS class that shows the loading spinner
    document.getElementById('spinner-submit-csv').classList.add('visually-hidden');
    document.getElementById('btn-submit-csv').classList.remove('visually-hidden');
    document.getElementById('btn-cancel-csv').click();
}

///////////////////////////////////////////////////////
// Get a reference to the form element
function addFormListen(){
    const form = document.getElementById('form-update-parent-category');

    if(form){
        // Add an event listener to the form's submit event
        form.addEventListener('submit', submitForm);
    }
    else
    {
        console.log("Form element not found");
    }
}

// Function to handle form submission
function submitForm(event) {
    event.preventDefault(); // Prevent the default form submission

    // Get a reference to the form element
    const form = document.getElementById('form-update-parent-category');

    // Create a new FormData object and pass the form element to it
    const formData = new FormData(form);
    formData.forEach((value, key) => {
            console.log(key, value);
        }
    );
    // Send a POST request to the server using the Fetch API
    fetch('/submit-url', {
        method: 'POST',
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            // Handle the response from the server
            console.log(data);
            // Perform any further actions or display success message
        })
        .catch(error => {
            // Handle any errors that occurred during the request
            console.error('Error:', error);
        });
}


async function replaceParentCategory(objId, name) {
    rootCategoryId = objId;
    var parentDiv = document.getElementById("list-group-category-product");
    parentDiv.innerHTML = ""; // Clear previous HTML content

    console.log('RootId: '+objId);
    localStorage.setItem('rootCategorySelected',objId.toString());

    let parentCategory = await getAllByParentId(objId);
    console.log(parentCategory);

    var parentDiv = document.getElementById("list-group-parent");
    parentDiv.innerHTML = ""; // Clear previous HTML content

    if (parentCategory.length === 0) {
        var emptyHtml = `
        <div class="row mb-3">
            <p class="text-muted">Trống !</p>
        </div>
    `;

        parentDiv.innerHTML = emptyHtml; // Append the empty HTML structure
    } else {
        // Iterate over categories2 and generate HTML dynamically
        parentCategory.forEach(function(category) {
            var html = `
            <div class="row mb-3">
                <div class="col">
                    <button id="btn-${category.id}" onclick="toggleActiveClass2(this); replaceProductCategory('${category.id}','${category.name}');" class="btn btn-outline-gray text-black btn-parent-category" >
                    <!-- Display the category name -->
                    <span>${category.name}</span>
                    </button>

                    </div>
                <div class="col col-auto float-right">
                    <a data-bs-toggle="modal" href="#modalCenter${category.id}" data-bs-target="#modalCenter${category.id}" class="btn btn-outline-secondary">
                        <i class="tf-icons bx bx-edit"></i>
                    </a>
                    <div class="modal fade" id="modalCenter${category.id}" tabindex="-1" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modalCenterTitle">Chỉnh sửa Nhóm loại</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <form id="form-update-parent-category" th:object="${category}">
                                    <div class="modal-body">
                                        <input hidden="hidden" type="text" id="id" name="id" class="form-control" value="${category.id}">
                                        <div class="row">
                                            <div class="col mb-3">
                                                <label for="name" class="form-label">Tên Nhóm loại</label>
                                                <input type="text" id="name" name="name" class="form-control" value="${category.name}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col mb-3">
                                                <label for="href" class="form-label">Đường dẫn</label>
                                                <input type="text" id="href" name="href" class="form-control" value="${category.href}">
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col mb-3">
                                                <label for="keywords" class="form-label">Từ khoá</label>
                                                <input type="text" id="keywords" name="keywords" class="form-control" value="${category.keywords.toString()}">
                                            </div>
                                        </div>
                                        
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                            Huỷ
                                        </button>
                                        <button type="submit" class="btn btn-primary">Lưu</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <a href="/admin/category/delete?id=${category.id}" class="btn btn-outline-secondary">
                        <i class="tf-icons bx bx-trash"></i>
                    </a>

                </div>
                
                </div>
        `;

            parentDiv.innerHTML += html; // Append each category's HTML to the parentDiv
        });
        addFormListen();
    }

    setParentIdToPCategory(objId);
    setParentnameToPCategory(name);
}

async function replaceProductCategory(objId, name) {
    parentCategoryId = objId;
    console.log('Parent Category: '+objId);
    localStorage.setItem('parentCategorySelected',objId.toString());

    let productCategory = await getAllByParentId(objId);
    console.log(productCategory);

    var parentDiv = document.getElementById("list-group-category-product");
    parentDiv.innerHTML = ""; // Clear previous HTML content

    if (productCategory.length === 0) {
        var emptyHtml = `
        <div class="row mb-3">
            <p class="text-muted">Trống !</p>
        </div>
    `;

        parentDiv.innerHTML = emptyHtml; // Append the empty HTML structure
    } else {
        // Iterate over categories2 and generate HTML dynamically
        productCategory.forEach(function(category) {
            var html = `
            <div class="row mb-3">
                <div class="col">
                    <button id="btn-${category.id}" onclick="toggleActiveClass3(this)" class="btn btn-outline-gray text-black btn-product-category" >
                    <!-- Display the category name -->
                    <span>${category.name}</span>
                    </button>

                    </div>
                <div class="col col-auto float-right">
                    <a data-bs-toggle="modal" href="#modalCenter${category.id}" data-bs-target="#modalCenter${category.id}" class="btn btn-outline-secondary">
                        <i class="tf-icons bx bx-edit"></i>
                    </a>
                    <div class="modal fade" id="modalCenter${category.id}" tabindex="-1" style="display: none;" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="modalCenterTitle">Chỉnh sửa Loại sản phẩm</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <form class="form-update-category" th:object="${category}" method="post">
                                    <div class="modal-body">
                                        <input hidden="hidden" type="text" id="id" name="id" class="form-control" value="${category.id}">
                                        <div class="row">
                                            <div class="col mb-3">
                                                <label for="name" class="form-label">Tên Loại sản phẩm</label>
                                                <input type="text" id="name" name="name" class="form-control" value="${category.name}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col mb-3">
                                                <label for="href" class="form-label">Đường dẫn</label>
                                                <input type="text" id="href" name="href" class="form-control" value="${category.href}">
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div class="col mb-3">
                                                <label for="keywords" class="form-label">Từ khoá</label>
                                                <input type="text" id="keywords" name="keywords" class="form-control" value="${category.keywords.toString()}">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col mb-3">
                                                <label for="available" class="form-label">Tình trạng</label>
                                                <input type="checkbox" id="available" name="available" class="form-check-input" checked="${category.available}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                            Huỷ
                                        </button>
                                        <button type="submit" class="btn btn-primary">Lưu</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <a href="/admin/category/delete?id=${category.id}" class="btn btn-outline-secondary">
                        <i class="tf-icons bx bx-trash"></i>
                    </a>

                </div>
                
                </div>
        `;

            parentDiv.innerHTML += html; // Append each category's HTML to the parentDiv
        });
    }

    setParentIdToProductCategory(objId);
    setParentnameToProductCategory(name);
}

async function getAllByParentId(pId) {
    try {
        const response = await fetch(`/admin/category/api/getAllByParentId?parentId=${pId}`);
        const data = await response.json();
        return data;
    } catch (error) {
        // Handle any errors that occur during the fetch request
        console.error('Error:', error);
        return []; // Return an empty array or any default value as needed
    }
}


function setParentIdToPCategory(parentId){
    const ParentId2 = document.getElementById("modalAddCategoryParentId2");
    ParentId2.value = parentId;
}

 function setParentnameToPCategory(parentName){
     const ParentName2 = document.getElementById("modalAddCategoryParentName2");
     ParentName2.value = parentName;
 }


function setParentIdToProductCategory(parentId){
    const ParentId3 = document.getElementById("modalAddCategoryParentId3");
    ParentId3.value = parentId;
}

function setParentnameToProductCategory(parentName){
    const ParentName3 = document.getElementById("modalAddCategoryParentName3");
    ParentName3.value = parentName;
}

function toggleActiveClass1(button) {
    var buttons = document.querySelectorAll('.btn-outline-gray.text-black.btn-root-category');
    buttons.forEach(function(btn) {
        btn.classList.remove('active');
    });
    button.classList.add('active');
}

function toggleActiveClass2(button) {
    var buttons = document.querySelectorAll('.btn-outline-gray.text-black.btn-parent-category');
    buttons.forEach(function(btn) {
        btn.classList.remove('active');
    });
    button.classList.add('active');
}

function toggleActiveClass3(button) {
    var buttons = document.querySelectorAll('.btn-outline-gray.text-black.btn-product-category');
    buttons.forEach(function(btn) {
        btn.classList.remove('active');
    });
    button.classList.add('active');
}





