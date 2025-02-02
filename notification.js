//button.addEventListeer("Test", () => {
    
function sendNotification() {
    Notification.requestPermission().then(perm => {
        if(perm === "granted"){
	        new Notification("BIO READING DUE 3PM!!!", {
                body: "Get Started Now It's due in 3 Hours!",
    	    })
        }
    })
}