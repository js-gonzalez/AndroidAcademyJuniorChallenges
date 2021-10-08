# AndroidAcademyJuniorChallenges v1.0.0
Android Academy Challenges redone for introductory topics in Android Development.

## Project Structure
### Modules
The Android project is structured in Android libraries with the challenge_opener module as the main app Android module. Each android library holds a main Activity to be started with an Intent from the main module.
|Module| Description | Topics
|--|--|--|
| **challenge_opener** | main module to open android libraries | Appbar, RecyclerView, Intent, Dialog
| **ui_design_copy** | ui design copy of hbo_max user selection | Layout, Compose, XML, Theme, Style
| **rxjava_exercise** | rxjava exercises for time-consuming use cases | RxJava, Clean Architecture, Dagger-Hilt, Mockito
| **api_image_viewer** | artwork images visualization through api consumption | Retrofit, Coroutines, ViewModel
| **...** | ... | ...

## Project Guidelines

### Resources naming

### 1. Styles

Styles names are written in **PascalCase**.

    WhatDescriptionStyle

- `What` explains where the style will be applied
- `Description` will be use to explain the style

*Ex.*
- **CardViewPromotionStyle**: Promotion Style applied to CardViews
- **ImageGrayScaleStyle**: Gray Scale Style applied to Images
- **TextViewChallengeStyle**: Challenge Style applied to TextView

### 2. Strings
They are written in **snake_case**.  (if any part of the scheme have two of more words, it will combine **camelCase**)

    what_where_description_type

- `what` will be an option like: layout, button, image, checkBoxes,  textView, etc.
- `where` it is optional and will indicate where the string will be used
- `description` what the string refers to
- `type` the type of string like: label, hint, etc.

`All` will be used if the string is used in several places in the app: `all_description`

*Ex.*
-   **img_movie_description**: image's description of a movie
-   **viewpager_tabLayout_opt_label**: a label of an tab layout's option in a viewPager
-   **txtView_activity_title_label**: a label of an activity’s title
-   **btn_challengeOne_label**: a label of a button
-   **fragment_feedbackName_hint**: hint of name field in FeedbackFragment
-   **all_done**: generic “done” string

### 3. Drawables
They are written in **snake_case**.

    what_name_modifier_size

- `what` will be an option like: ic, image, shape, etc.
- `name` the drawable name based on it's representation
- `modifier` the modification to the filled icon like: outline, transparent, etc.

`size` is optional and used when the size is defined as: units in dp's "24dp" or qualitative "small"

Ex.
- **placeholder_articledetail**: placeholder in ArticleDetailFragment
- **ic_all_info**: generic info icon
- **ic_all_info_large**: large version of generic info icon
- **sl_help**: selector of a help icon
- **img_dog**: an image of a dog

### 4. IDs
They are written in **snake_case**.

    what_description_type

- `what` will be an option like layout, button, image, checkBoxes, EditText, ToggleButton, textView, etc.
- `description` is to know what that ID refers to

*Ex.*
- **btn_movie_watchNow**: a button for watching a movie
- **txtview_movieSeason_status**: a textView with movie season's status
- **txtview_movieSeason**: a textView with the movie's season
- **txtview_moviesFragment_title**: a textView with the movie fragment's title

### 5. Dimensions
They are written in **snake_case**. (if any part of the scheme have two of more words, it will combine **camelCase**)

    what_description_type_size

- `what` will be an option like layout, button, image, checkBoxes, EditText, ToggleButton, textView, etc.
- `description` is to know what that dimensions refers to
- `type` will tell any option at the list below

|**Prefix**|**Usage**|
|--|--|
|**width**| width in dp |
|**height**|height in dp|
|**size**|if width == height|
|**margin**|margin in dp|
|**padding**|padding in dp|
|**elevation**|elevation in dp|
|**keyline**|absolute keyline measured from view edge in dp|
|**textSize**|size of text in sp|

Other dimensions like rotation, scale, ... are usually used in drawables and are hardly reusable.

*Ex.*
- **all_margin_16dp**: 16dp for all margins
- **margin_medium**: the size of margin is medium
- **all_textSize_16sp**: all size of text in 16sp
- **textSize_medium**: medium size of all text
- **img_corner_radius**
- **fragm_title_textSize**: a size of a text in a fragment’s title
- **icon_menu_size**: size of icons in menu
- **profileImage_menu_height**: height of profile image in menu
- **toolbar_height**: height of all toolbars
- **listText_keyline**: listitem text is aligned at this keyline

### 6. Layouts
They are written in **snake_case**

    what_description_category.xml

- `category` determines the hierarchy of an item in a similar named group like: main, group, item, etc.

|Prefix| Usage |
|--|--|
| **activity** | content view for activity |
| **fragment** | view for a fragment |
| **view** | inflated by a custom view |
| **item** | layout used in list/recycler/gridview |
| **layout** | layout reused using the include tag |

*Ex.*
- **activity_main**: content view of the MainActivity
- **fragment_article_detail**: view for the ArticleDetailFragment
- **view_menu**: layout inflated by custom view class MenuView
- **item_article**: list item in ArticleRecyclerView

# References

- https://jeroenmols.com/blog/2016/03/07/resourcenaming/
- https://github.com/umesh0492/android-guidelines/blob/master/project_and_code_guidelines.md#11-project-structure

