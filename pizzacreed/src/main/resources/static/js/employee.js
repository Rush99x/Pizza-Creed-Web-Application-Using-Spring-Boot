const BASE_URL = "http://localhost:3000/api/pizzas";

function getPizzas() {
  $.ajax({
    url: BASE_URL,
    method: "GET",
    success: function (data) {
      displayPizzas(data);
    },
    error: function (xhr, textStatus, errorThrown) {
      console.log(xhr.responseText);
    },
  });
}

function displayPizzas(pizzas) {
  let pizzaTable = $("#pizzaTable");
  pizzaTable.empty();
  for (let pizza of pizzas) {
    let row = $("<tr></tr>");
    row.append($(`<td>${pizza._id}</td>`));
    row.append($(`<td>${pizza.name}</td>`));
    row.append($(`<td>${pizza.flavor}</td>`));
    row.append($(`<td>${pizza.size}</td>`));
    row.append($(`<td>${pizza.description}</td>`));
    row.on("click", function () {
      $("#id").val(pizza._id);
      $("#name").val(pizza.name);
      $("#flavor").val(pizza.flavor);
      $("#size").val(pizza.size);
      $("#description").val(pizza.description);
    });
    pizzaTable.append(row);
  }
}

function savePizza() {
  let name = $("#name").val();
  let flavor = $("#flavor").val();
  let size = $("#size").val();
  let description = $("#description").val();

  $.ajax({
    url: BASE_URL,
    method: "POST",
    data: {
      name: name,
      flavor: flavor,
      size: size,
      description: description,
    },
    success: function (data) {
      alert("Pizza saved successfully!");
      clearFields();
      getPizzas();
    },
    error: function (xhr, textStatus, errorThrown) {
      console.log(xhr.responseText);
    },
  });
}

function updatePizza() {
  let id = $("#id").val();
  let name = $("#name").val();
  let flavor = $("#flavor").val();
  let size = $("#size").val();
  let description = $("#description").val();

  $.ajax({
    url: BASE_URL + "/" + id,
    method: "PUT",
    data: {
      name: name,
      flavor: flavor,
      size: size,
      description: description,
    },
    success: function (data) {
      alert("Pizza updated successfully!");
      clearFields();
      getPizzas();
    },
    error: function (xhr, textStatus, errorThrown) {
      console.log(xhr.responseText);
    },
  });
}

function deletePizza() {
  let id = $("#id").val();

  $.ajax({
    url: BASE_URL + "/" + id,
    method: "DELETE",
    success: function (data) {
      alert("Pizza deleted successfully!");
      clearFields();
      getPizzas();
    },
    error: function (xhr, textStatus, errorThrown) {
      console.log(xhr.responseText);
    },
  });
}

function clearFields() {
  $("#id").val("");
  $("#name").val("");
  $("#flavor").val("");
  $("#size").val("");
  $("#description").val("");
}

$(document).ready(function () {
  getPizzas();
});
