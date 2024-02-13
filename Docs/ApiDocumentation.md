# Api Docs
## By Group 2


### 1.1 Sign In and Authenticate
    [POST] /api/auth/login
    To log into an account that we have already registered.
    Headers: None
    Body: { username:string,
            password:string}
    Response: {
        username: string,
 	password:string
    }
    

![alt_text](./assets/SignIn.png "image_tooltip")

<br>

### 1.2 Create an Account
    [POST] /api/auth/registration
    To create a new user and is insert it into the 
    database.
    Headers: None
    Body: { username:string,
            password:string}
![alt_text](./assets/Signup.png "image_tooltip")


<br>




    
### 4.1 Get All Papers
    [GET] /api/paper/all
    Retrieves all papers.
    Headers: None
    Body: None
    Response: 
        200 OK - List of Papers:
        [
            {
                "id": "string",
                "status": "string",
                "paperName": "string",
                "rating": number or null,
                "authorName": "string",
                "tags": ["string"],
                "reviews": [
                    {
                        "reviewer": "string",
                        "comments": "string",
                        "rating": number,
                        "reviewerDecision": "string"
                    },
                    // ... additional review objects
                ],
                "decision": "string"
            },
            // ... additional paper objects
        ]

        404 Not Found - If there are no papers or an error occurs.

![alt_text](./assets/getall.png "image_tooltip")

### 4.2 Get Paper By Id

    [GET] /api/paper/{id}
        Retrieves a paper by ID.
        Headers: None
        Body:None
        Path Parameters:
            - id: (String) The ID of the paper.
        Response:
            200 OK - Paper:
            {
                "id": "string",
                "status": "string",
                "paperName": "string",
                "rating": number or null,
                "authorName": "string",
                "tags": ["string"],
                "reviews": [
                    {
                        "reviewer": "string",
                        "comments": "string",
                        "rating": number,
                        "reviewerDecision": "string"
                    },
                    // ... additional review objects
                ],
                "decision": "string"
            }

        404 Not Found - If the paper with the specified ID is not found.
        
![alt_text](./assets/getbyid.png "image_tooltip")

### 4.3 Update Decision of Paper
    [PUT] /api/paper/updateDecision/{id}?newDecision=decision
        Updates the decision of a paper by ID to 'decision'.
        Headers: None
        Body: None
        Path Parameters:
            - id: (String) The ID of the paper.
        Query Parameters:
            - newDecision: (String) The new decision status (e.g., 'Accept','Reject').
        Response:
            200 OK - String:
            "Paper decision updated successfully"
    
            404 Not Found - If the paper with the specified ID is not found.

### 4.4 Update Reviewer
    [PUT] /api/dashboard/paperDetails?id=3
    	Updates the reviewer for a paper(in case the assigned reviewer failed to do the task)
     	Headers:None
      	Body:None
       	Path Parameters:
		-id: (Integer) ID of the paper
  	Query Parameters:
   		-Reviewer: (String) the new decision status (eg.,'faculty1,faculty2')
     	Response: Page gets reloaded immediately and displays new reviewer.
            
![alt_text](./assets/updatedecision.png "image_tooltip")


