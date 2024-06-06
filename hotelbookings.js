function validateDates() {
    var checkInDate = new Date(document.getElementById("checkIn").value);
    var checkOutDate = new Date(document.getElementById("checkOut").value);

    if (checkOutDate <= checkInDate) {
        alert("Check-out date must be after check-in date.");
        return false;
    }

    return true;
}