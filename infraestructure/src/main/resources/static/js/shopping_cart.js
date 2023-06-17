
    function addToCart(product) {
    // Get the values from the product object
    var objId = product.id;
    var productName = product.name;
    var productPrice = parseFloat(product.price);
    var productDiscount = parseInt(product.discount);
    var productImage = product.descriptionImages[0];
    var productQuantity = 1;
    // Calculate the total
    var total = productPrice * productQuantity;

    // Get the existing cart items from localStorage
    var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];

    // Create a new item object
    var newItem = {
        id: objId,
        product: productName,
        image: productImage,
        discount:productDiscount,
        price: productPrice,
        quantity: productQuantity,
        total: total
};

    // Add the new item to the cart
    cartItems.push(newItem);

    // Store the updated cart items in localStorage
    localStorage.setItem("cartItems", JSON.stringify(cartItems));

}
