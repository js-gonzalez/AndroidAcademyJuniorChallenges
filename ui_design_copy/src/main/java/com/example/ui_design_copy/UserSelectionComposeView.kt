package com.example.ui_design_copy

import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.ui_design_copy.ui.layouts.ProfilesCenteredGridLayout

object Constants {
    const val PROPORTION_PROFILE_TO_LOCK_SIZE = 3
    const val PROPORTION_LOCK_TO_ICON = 2
    const val FADE_COIL_PROFILE = 500
}

@Composable
fun ProfileScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .background(
                Brush.linearGradient(
                    listOf(
                        colorResource(id = R.color.jaguar),
                        colorResource(id = R.color.indigo_persian),
                        colorResource(id = R.color.valentino),
                        colorResource(id = R.color.jaguar)
                    ),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item { ProfileTopAppBar(modifier = Modifier) }
        item {
            Text(
                text = stringResource(id = R.string.title_question_txt),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = dimensionResource(id = R.dimen.title_question_size).value.sp,
                color = colorResource(id = R.color.title_question_color)
            )
        }
        item {
            ProfileLayoutInstance(
                (1..11).random(),
                dimensionResource(R.dimen.img_profile_size).value.toInt()
            )
        }
        item { ManageProfilesSection() }
    }
}

@Composable
fun ProfileTopAppBar(modifier: Modifier) {
    val zeroPadding = dimensionResource(R.dimen.viewGroup_padding_0dp)
    TopAppBar(
        modifier.padding(
            dimensionResource(id = R.dimen.topAppBar_hboMaxToolbar_padding),
            dimensionResource(id = R.dimen.topAppBar_hboMaxToolbar_padding_top),
            dimensionResource(id = R.dimen.topAppBar_hboMaxToolbar_padding),
            zeroPadding
        ),
        backgroundColor = Color.Transparent,
        elevation = zeroPadding
    ) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.ic_navbar_size)))
            Icon(
                painter = painterResource(id = R.drawable.ic_hbo_max_logo),
                contentDescription = stringResource(R.string.hbomax_logo_description),
                Modifier.width(dimensionResource(id = R.dimen.ic_hbo_width)),
                tint = Color.White
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_cast),
                contentDescription = stringResource(R.string.ic_cast_description),
                Modifier.clickable { },
                tint = Color.White
            )
        }
    }
}

@Composable
fun ProfileHBO(
    modifier: Modifier,
    profileImgSrc: String,
    viewSize: Int,
    @ColorRes profileImgBorderColor: List<Int>,
    profileName: String,
    kidProfile: Boolean
) {

    val lockSize = viewSize / Constants.PROPORTION_PROFILE_TO_LOCK_SIZE
    val lockIconSize = lockSize / Constants.PROPORTION_LOCK_TO_ICON
    val viewPadding = dimensionResource(id = R.dimen.viewGroup_profile_hbo_padding)
    val zeroPadding = dimensionResource(R.dimen.viewGroup_padding_0dp)
    val profileImgBorderGradient = Brush.linearGradient(
        profileImgBorderColor.map { colorResource(id = it) }, start = Offset.Zero,
        end = Offset.Infinite
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable { }
            .padding(viewPadding, viewPadding, viewPadding, zeroPadding)
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = rememberImagePainter(
                    data = profileImgSrc,
                    builder = {
                        placeholder(R.drawable.ic_image_search)
                        error(R.drawable.ic_broken_image)
                        crossfade(Constants.FADE_COIL_PROFILE)
                        transformations(CircleCropTransformation())
                    }
                ),
                contentDescription = "$profileName profile picture",
                modifier = Modifier
                    .size(viewSize.dp)
                    .clip(CircleShape)
                    .border(
                        dimensionResource(id = R.dimen.img_profile_hbo_borderWidth),
                        profileImgBorderGradient,
                        shape = CircleShape
                    )
            )
            if (kidProfile) {
                Box(
                    modifier = Modifier
                        .background(
                            colorResource(R.color.white_translucid),
                            CircleShape
                        )
                        .size(lockSize.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_lock),
                        contentDescription = "Kid Profile",
                        Modifier.size(lockIconSize.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.viewGroup_padding_4dp)))
        Text(
            profileName,
            modifier = Modifier.width(viewSize.dp),
            textAlign = TextAlign.Center,
            color = colorResource(R.color.title_question_color),
            fontSize = dimensionResource(R.dimen.user_name).value.sp
        )
    }
}

@Composable
fun ProfileLayoutInstance(subListN: Int, size: Int) {
    val data = ProfileSelectInfoData()().let {
        if (subListN > it.size) {
            it
        } else {
            it.subList(0, subListN)
        }
    }
    ProfilesCenteredGridLayout(Modifier) {
        data.forEach { profile ->
            ProfileHBO(
                Modifier,
                profile.profileImgSource,
                size,
                profile.profileImgBorderColors,
                profile.profileName,
                profile.kidProfile,
            )
        }
    }
}

@Composable
fun ManageProfilesSection() {
    val zeroPadding = dimensionResource(R.dimen.viewGroup_padding_0dp)
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.viewGroup_manageProfiles_padding)),
            Arrangement.SpaceAround
        ) {
            Row {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(R.color.cream_translucid),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.btn_manageProfiles_adult_width))
                        .clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = stringResource(R.string.btn_manageProfiles_adult_description)
                    )
                    Text(
                        text = stringResource(R.string.btn_manageProfiles_adult_txt).uppercase(),
                        fontSize = dimensionResource(R.dimen.btn_manageProfiles_txtSize).value.sp
                    )
                }
                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.spacer_addBtns_width)))
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = colorResource(R.color.cream_translucid),
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.btn_manageProfiles_adult_width))
                        .clip(CircleShape)

                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add),
                        contentDescription = stringResource(R.string.btn_manageProfiles_kid_description)
                    )
                    Text(
                        text = stringResource(R.string.btn_manageProfiles_kid_txt).uppercase(),
                        fontSize = dimensionResource(R.dimen.btn_manageProfiles_txtSize).value.sp
                    )
                }
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(
                    zeroPadding,
                    zeroPadding,
                    zeroPadding,
                    dimensionResource(R.dimen.viewGroup_manageProfiles_padding_bottom)
                ),
            Arrangement.SpaceEvenly
        ) {
            TextButton(
                onClick = { },
                Modifier
                    .wrapContentWidth()
                    .padding(
                        zeroPadding,
                        zeroPadding,
                        zeroPadding,
                        dimensionResource(R.dimen.viewGroup_manageProfiles_padding)
                    )
            ) {
                Text(
                    text = stringResource(R.string.btn_manageProfiles_manage_txt),
                    fontSize = dimensionResource(R.dimen.btn_manageProfiles_txtSize).value.sp
                )
            }
        }
    }
}
