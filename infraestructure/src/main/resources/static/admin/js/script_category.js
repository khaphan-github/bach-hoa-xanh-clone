
const rootCategorySelected = localStorage.getItem('rootCategorySelected');
const parentCategorySelected = localStorage.getItem('parentCategorySelected');


// Get the file input element
const fileInput = document.getElementById('formFileCsv');

// Add an event listener to the file input element
if (fileInput) {
    fileInput.addEventListener('change', handleFileUpload);
} else {
    console.error("File input element not found!");
}
// Function to handle the file upload
async function handleFileUpload(event) {
    if (event.target && event.target.files.length > 0) {
        const file = event.target.files[0]; // Get the selected file
        appendTableDisplayCsv();
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

                console.log('Sheet:', sheetName);
                console.log('Data:', jsonData);


                // Save the data in a variable or use it as needed
                const mainSheetData = jsonData;

            };

            await reader.readAsArrayBuffer(file);


        }
    }

}
async function appendTableDisplayCsv(){
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
                                <tr>
                                    <td>
                                        <i class="fab fa-angular fa-lg text-danger me-3"></i> <strong>Angular Project</strong>
                                    </td>
                                    <td>Albert Cook</td>
                                    <td><span class="badge bg-label-primary me-1">Active</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                `;
        console.log(html);
        tableDisplayDiv.innerHTML = html;
}
////////////////////////////////////////////////////////
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
                    <a href="/admin/category/delete/${category.id}" class="btn btn-outline-secondary">
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
                    <a href="/admin/category/delete/${category.id}" class="btn btn-outline-secondary">
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
         const response = await fetch('/admin/category/api/getAllByParentId/' + pId);
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





