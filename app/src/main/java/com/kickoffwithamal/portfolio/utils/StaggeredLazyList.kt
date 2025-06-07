package com.kickoffwithamal.portfolio.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kickoffwithamal.portfolio.R
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

data class ProfileLink(val name: String, val url: String, val iconResId: Int)

@Preview
@Composable
fun StaggeredLazyList() {
    val uriHandler = LocalUriHandler.current

    val profiles = listOf(
        ProfileLink("GitHub", "https://github.com/KickOffWithAmal", R.drawable.github_img),
        ProfileLink("LinkedIn", "https://www.linkedin.com/in/amal-ramachandran-b42b11210/", R.drawable.linkedin_img),
        ProfileLink("Medium", "https://medium.com/@amalramachandran25", R.drawable.medium_img),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(profiles) { profile ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
                    .clickable {
                        uriHandler.openUri(profile.url)
                    }
            ) {
                Image(
                    painter = painterResource(id = profile.iconResId),
                    contentDescription = "${profile.name} icon",
                    modifier = Modifier.size(36.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = profile.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }


}