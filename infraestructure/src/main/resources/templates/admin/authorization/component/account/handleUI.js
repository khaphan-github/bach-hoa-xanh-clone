// WHEN CLICK CHANGE TAG IN MAIN PAGE
function renderAccountTable() {

  const data = fetchAccounts();
  const tableBody = document.querySelector('#authorization-account-data-table tbody');

  // Clear existing table data
  tableBody.innerHTML = '';

  // Loop through the data and generate table rows
  data.forEach((item) => {
    const row = document.createElement('tr');

    const nameCell = document.createElement('td');
    nameCell.textContent = item.name;
    row.appendChild(nameCell);

    const usernameCell = document.createElement('td');
    usernameCell.textContent = item.username;
    row.appendChild(usernameCell);

    const phoneCell = document.createElement('td');
    phoneCell.textContent = item.phone;
    row.appendChild(phoneCell);

    const emailCell = document.createElement('td');
    emailCell.textContent = item.email;
    row.appendChild(emailCell);

    const groupCell = document.createElement('td');
    const groupBadges = item.group.map((group) => `<span class="badge bg-label-primary me-1">${group.name}</span>`);
    groupCell.innerHTML = groupBadges.join('');
    row.appendChild(groupCell);

    const statusCell = document.createElement('td');
    statusCell.innerHTML = `<span class="badge bg-label-primary me-1">${item.status}</span>`;
    row.appendChild(statusCell);

    const actionsCell = document.createElement('td');
    const viewButton = document.createElement('button');
    viewButton.setAttribute('type', 'button');
    viewButton.setAttribute('class', 'btn btn-sm btn-primary');
    viewButton.setAttribute('data-bs-toggle', 'modal');
    viewButton.setAttribute('data-bs-target', '#exLargeAccountModal');
    viewButton.textContent = 'Xem chi tiết';

    viewButton.addEventListener('click', () =>  renderAccountFormModel(item));

    actionsCell.appendChild(viewButton);
    row.appendChild(actionsCell);

    // Append the row to the table body
    tableBody.appendChild(row);
  });
}

let groupSelected = [];

function renderAccountFormModel (content) {
    if (content === 'empty') {
        bindGroupFormModel(fetchGroup(), true ,(selectedId) => {
          groupSelected = selectedId
        });
        setInputAccountInformationValue({});
    }
    else {
        bindGroupFormModel(content.group, false, (selectedId) => {
              groupSelected = selectedId
        });
        setInputAccountInformationValue(content)
    }
}

function getInputAccountInformationInputElement() {
    return {
        name: 'basic-default-fullname',
        username: 'basic-default-username',
        password: 'basic-default-password',
        phone: 'basic-default-phone',
        email: 'basic-default-email',
        status: 'flexSwitchCheckDefault',
    };
}

function getInputAccountInformationValue() {
    const elementId = getInputAccountInformationInputElement();
    const updatedData = Object.entries(elementId).reduce((data, [key, id]) => {
    const input = document.getElementById(id);
    data[key] = input.value;
    return data;
  }, {});
  return updatedData;
}



function handleSaveChanges() {
  const account =  getInputAccountInformationValue();
  console.log(account);
  console.log(groupSelected);
}


function setInputAccountInformationValue(account) {
    console.log(account);
  const elementId = getInputAccountInformationInputElement();

  Object.entries(elementId).forEach(([key, id]) => {
    const input = document.getElementById(id);
    input.value = account[key] || '';
  });
}
