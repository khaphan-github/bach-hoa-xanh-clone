document.getElementById('formAuthentication')
.addEventListener('submit', function (event) {
  event.preventDefault();
  var email = document.getElementById('email').value;
  var password = document.getElementById('password').value;
  var rememberMe = document.getElementById('remember-me').checked;

  var requestBody = {
    username: email,
    password: password,
    rememberMe: rememberMe
  };

  fetch('/admin/authenticate', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(requestBody)
  })
    .then(function (response) {
      if (response.ok) {
        return response.text();
      } else {
        throw new Error('Invalid credentials');
      }
    })
    .then(function (token) {
      localStorage.setItem('token', token);
      window.location.href = '/admin/dashboard';
    })
    .catch(function (error) {
      window.location.href = '/admin/login';
    });
});
