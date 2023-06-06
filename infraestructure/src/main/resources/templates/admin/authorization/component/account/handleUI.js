function renderAccountTable() {
  const data = fetchAccounts();
  const tableBody = document.querySelector('#authorization-account-data-table tbody');

  // Clear existing table data
  tableBody.innerHTML = '';

  // Loop through the data and generate table rows
  data.forEach((item) => {
    const row = document.createElement('tr');

    // Generate table cells for each property
    const avatarCell = document.createElement('td');
    const avatarImage = document.createElement('img');
    avatarImage.setAttribute('src', item.avatar);
    avatarImage.setAttribute('alt', '');
    avatarCell.appendChild(avatarImage);
    row.appendChild(avatarCell);

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
    const groupBadges = item.group.map((group) => `<span class="badge bg-label-primary me-1">${group}</span>`);
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
    viewButton.setAttribute('data-bs-target', '#exLargeModal');
    viewButton.textContent = 'Xem chi tiết';
    actionsCell.appendChild(viewButton);
    row.appendChild(actionsCell);

    // Append the row to the table body
    tableBody.appendChild(row);
  });
}