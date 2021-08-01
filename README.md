# 💲WorthOrNot💲 (Team 3)

## Table of Contents 📋
- [Description ℹ️](#description)
- [Design 🎨](#design)
- [Features 💡](#features)
- [User Guide ❓](#user-guide)
- [Members 🎓](#members)
- [Acknowledgements 🙏](#acknowledgements)
  
## Description 
ℹ️**WorthOrNot** is a Mobile Application that aims to improve its users' experience when grocery shopping.
This improvement will be attained by fulfilling these 3 criteria:
  1. Minimising spending costs
  2. Reducing time spent making decisions
  3. Improving quality of decisions made

## Design 
🎨This application is built with an overall minimalist aesthetic in mind in order to reduce clutter and 
maximise focus when shopping. 
- [Raleway](https://fonts.google.com/specimen/Raleway) font is used for its elegance and great readability. 
- Background color used throughout the app is a gray color ![#D6CFCB](https://via.placeholder.com/15/D6CFCB/000000?text=+) `#D6CFCB` for its simplicity 
- Text color, and icons is a darker gray ![#503d42](https://via.placeholder.com/15/503d42/000000?text=+) `#503d42` to contrast background and improve readability. 
- Button elements are colored with a dark blue ![#16697A](https://via.placeholder.com/15/16697A/000000?text=+) `#16697A` to bring home the overall minimal and calm vibe of the app

![image](https://user-images.githubusercontent.com/77566547/127747409-ae933ee0-00fd-475a-be83-6b11e178cc39.png)

## Features 
💡Below are brief descriptions of the features implemented into this application,
detailed, step-by-step operation of each feature will be underlined in the [User Guide](#user-guide) section.

  #### Bottom Navigation bar
  - The application can be smoothly navigated across the 3 main pages, and homepage, with this navigation
    bar located at the bottom of the screen.
    
    ![image](https://user-images.githubusercontent.com/77566547/127747521-84807c93-9c5e-4f06-880a-d08ae1e7fc53.png)
    
  #### Comparer
  - This feature fulfills criteria #3 and #1 under the descirption. It allows users to add in the price and amount of a product
    they find during a grocery shopping trip, and quickly compare them against each other to determine the product
    with best value, therefore saving on both time and money. The product can also be directly added from the Compare feature,
    into the Shopping List feature. 
    
    In practice, a user could come across 2 different boxes of cereal from 2 different brands, 
    Brand A and B for example. Brand A provides 500g of cereal at $4.50, whereas Brand B provides 800g for $11.90, 
    
![image](https://user-images.githubusercontent.com/77566547/127747574-73d0df95-288c-46e4-8b38-9450f22fde3d.png)

  #### Advice
  - This feature fulfills criteria #3 of the descirption as well, by letting a user navigate to a page where description of 
    products can be displayed to better inform a user's decision when purchasing products.
    
    ![image](https://user-images.githubusercontent.com/77566547/127747582-05e270b9-82c9-48ad-b282-2739277c44e0.png)
  
  #### Shopping List
  - This feature fulfills criteria #2, by allowing a user to plan their trip to the grocery store before they even 
    leave the house. The items stored in the list are inputted completely up to the user's exact specifications, with a dynamically
    changing icon according to the type of product.
    
  ![image](https://user-images.githubusercontent.com/77566547/127764502-25d26d8b-6862-4437-a01b-05ea9b620a6d.png)  
  
  #### Firebase 
  - Firebase is a Backend as a Service (BaaS) application that acts as a backend server for the mobile application. Firebase provides Firestore Database, Realtime Database,          Authentication, Crash analytics, Google analytics, Remote Configuration, and Cloud Messaging. This is helpful to developers because it provides a quick installation of the      databases, collates all application crash analytics. This is used within the app to monitor user traffic and log crashes for patching.


## User Guide 
 ❓ A user first opens the app, and is navigated to the homepage. 3 large icons are available to easily be redirected to any of the 3 features available.
 The bottom nav bar is also available for users to navigate throughout the app.
 
 #### **Usage of Compare page**
 1. User would come across 2 different brands of the same product _(ie. 2 apples from brand A and brand B )_
 2. Fill out the Brand field of one of the products _(Input "Brand A" into the Brand field)_
 3. Fill out the price and amount of the same product as above _(Input price and Weight of Apple from Brand A into respective fields)_
 4. Tap on the Add to Compare button, the product will appear in the list
 5. Repeat steps 1-4 for the other product, or as many products as desired
 6. The brand of the product, as well as the value (value = price / amount) will be displayed in the table, from left to right
 7. User can then look between the products being compared and determine which product is most worth~~or not~~
 
 +  **Additionally,** any products added into the Compare table can be added directly to the shopping list if desired. 
    This can be done by tapping on the "Add to Shopping List" button found on each product listed in the Compare table. 
    
    1. All previously filled fields by user (Price, Brand and Amount) will be automatically filled, and can still be editted.
    2. User can input additional information needed for a shopping list such as the Name and Quantity to be purchased 
    3. Upon tapping the "Add to Shopping List" button, user will be redirected to the Shopping List page where the product is 
       saved.
    
 #### **Usage of Advice Page**
 1. User can scroll through the list of products found in this page
 2. Upon selection of any of the items, they will be redirected to a second page where the description of the item is 
    elaborated on.
 3. User can then make a more informed decision of the product they are buying, after understanding more from the description.
 
 
 #### **Usage of Shopping List Page**
 1. User first taps on the "+" icon on the top left corner, where a page will appear to take in user inputs
 2. User can input details of the product (Name, Quantity, Brand, Price etc.)
 3. Tap on the button located on bottom of the screen "Add to Shopping List"
 4. Item will appear in the original page. User can then check off the items with the built in check box as they shop 
    in real life.
 5. After the list is completed, the reset button can be tapped to clear the list of items. Individual items can also be removed
   by swiping to the right on the specific item.

## Members 
🎓 Detailed here are the members of the team, and their contributions:

- Muhammad Aidel Sufyan Abdul Manap 👽 _(S10208133)_
  - Leader
  - Designed UI & Animations
  - Designed Bottom Navigation Bar
  - Implemented Shopping List Page
  - Implemented searchable spinner
  - Implemented Firebase
 
- Muhammad Fahmi Jumahat 👺 _(S10208183)_
  - Implemented Database
  - Designed Pitch slides
  - Implemented Shopping List Page
  - Implemented Firebase
  
- Tan Jing Yu 🙃 _(S10204382)_ 
  - Implemented Comparer Page
  - Implemented Advice Page
  - Implemented Add To Shopping List 
  - Designed UI & Layout
  - Wrote this whole file you're reading now

## Acknowledgements
🙏 Thank you to all who helped along the way
  - Coolest gamer cher ~~Mr~~  Ben 🕹️ (for helping us even in the hospital) _we hope your foot is better_
  - [StackOverFlow](https://stackoverflow.com/)
  - [Emojipedia](https://emojipedia.org/)
  - [clemon](https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley)
