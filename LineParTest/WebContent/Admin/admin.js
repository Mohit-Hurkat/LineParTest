
function myFunction(x) {
    document.getElementById(x).style.display="block";
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropdownadmin')) {

    var dropdown = document.getElementsByClassName("dropdownadmin");
    dropdown.display="none";
    
//    var i;
//    for (i = 0; i < dropdowns.length; i++) {
//      var openDropdown = dropdowns[i];
//      if (openDropdown.classList.contains('show')) {
//        openDropdown.classList.remove('show');
      }
    }
