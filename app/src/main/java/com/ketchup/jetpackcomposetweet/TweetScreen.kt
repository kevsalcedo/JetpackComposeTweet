package com.ketchup.jetpackcomposetweet

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ketchup.jetpackcomposetweet.ui.theme.JetpackComposeTweetTheme

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    JetpackComposeTweetTheme {
        TweetScreen()
    }
}

@Composable
fun TweetScreen() {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        Column {
            Tweet()
            Divider(color = Color(0xFFB5B5B5))
        }
    }
}

@Composable
fun Tweet() {
    Row(Modifier.padding(top = 16.dp, end = 32.dp, bottom = 12.dp, start = 16.dp)) {
        TweetProfileLogo()
        Spacer(Modifier.size(16.dp))
        TweetBody()
    }
}

@Composable
fun TweetBody() {
    Column() {
        TweetHeader()
        TweetInformation()
        TweetInteraction()
    }
}

@Composable
fun TweetInteraction() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ChatInteraction()
        Spacer(Modifier.size(50.dp))
        RetweetInteraction()
        Spacer(Modifier.size(50.dp))
        LikeInteraction()

    }
}

@Composable
fun LikeInteraction() {
    var likeCount by rememberSaveable {
        mutableStateOf(1)
    }
    var likeIconUsed by rememberSaveable {
        mutableStateOf(false)
    }
    var image = if (likeIconUsed) {
        R.drawable.ic_like_filled
    } else {
        R.drawable.ic_like
    }
    var color = if (likeIconUsed) {
        Color.Red
    } else {
        Color(0xFFB5B5B5)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Like icon",
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    likeIconUsed = !likeIconUsed
                    if (likeCount == 1) {
                        likeCount = 2
                    } else if (likeCount == 2) {
                        likeCount = 1
                    }
                },
            colorFilter = ColorFilter.tint(color = color)
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = likeCount.toString(),
            color = Color(
                0xFFB5B5B5
            )
        )
    }
}

@Composable
fun RetweetInteraction() {
    var retweetCount by rememberSaveable {
        mutableStateOf(1)
    }
    var retweetIconUsed by rememberSaveable {
        mutableStateOf(false)
    }
    var color = if (retweetIconUsed) {
        Color.Green
    } else {
        Color(0xFFB5B5B5)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_rt),
            contentDescription = "RT icon",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    retweetIconUsed = !retweetIconUsed
                    if (retweetCount == 1) {
                        retweetCount = 2
                    } else if (retweetCount == 2) {
                        retweetCount = 1
                    }
                },
            colorFilter = ColorFilter.tint(color = color)
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = retweetCount.toString(),
            color = Color(
                0xFFB5B5B5
            )
        )
    }
}

@Composable
fun ChatInteraction() {
    var chatCount by rememberSaveable {
        mutableStateOf(1)
    }
    var chatIconUsed by rememberSaveable {
        mutableStateOf(false)
    }
    var imagen = if (chatIconUsed) {
        R.drawable.ic_chat_filled
    } else {
        R.drawable.ic_chat
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = "chat icon",
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    chatIconUsed = !chatIconUsed
                    if (chatCount == 1) {
                        chatCount = 2
                    } else if (chatCount == 2) {
                        chatCount = 1
                    }
                },
            colorFilter = ColorFilter.tint(color = Color(0xFFB5B5B5))
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = chatCount.toString(),
            color = Color(
                0xFFB5B5B5
            )
        )
    }
}

@Composable
fun TweetInformation() {
    Column(Modifier.padding(vertical = 8.dp)) {
        TweetText()
        Spacer(Modifier.size(12.dp))
        TweetImage()
    }
}

@Composable
fun TweetImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Tweet image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(50f)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TweetText() {
    Text(
        text = "Yo no soy celoso, pero quien es ese cabron, dime quien es ese cabron, tranquila no soy psyco, no voy a hacer un papelon pero, ouch, mi corazón...",
        color = Color.White
    )
}

@Composable
fun TweetHeader() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TweetInformationHeader()
        Image(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Dots icon",
            colorFilter = ColorFilter.tint(Color.White),
        )
    }
}

@Composable
fun TweetInformationHeader() {
    Row() {
        Text(text = "KS", fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(Modifier.size(8.dp))
        Text(text = "@KevSalcedo", color = Color(0xFFB5B5B5))
        Spacer(Modifier.size(8.dp))
        Text(text = "4h", color = Color(0xFFB5B5B5))
    }
}

@Composable
fun TweetProfileLogo() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Circular profile imagen",
        modifier = Modifier
            .clip(CircleShape)
            .size(70.dp)
    )
}
