function updateFinishButton() {
	if (document.getElementById('reduceMesh:serviceExist').value == 'true') {
		document.getElementById('reduceMesh:finishButton').disabled='disabled';
	} else {
		document.getElementById('reduceMesh:finishButton').disabled='';
    }
}
