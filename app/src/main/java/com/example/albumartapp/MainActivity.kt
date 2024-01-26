package com.example.albumartapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AlbumBody()
                }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumBody(
    modifier: Modifier= Modifier
) {
    val scrollState = rememberScrollState()
    var currentImageIndex by remember {
        mutableStateOf(0)
    }
    val imageList = listOf(
        R.drawable.graduation_pic_1,
        R.drawable.graduation_pic_2,
        R.drawable.graduation_pic_3,
        R.drawable.graduation_pic_4,
        R.drawable.graduation_pic_5,
        R.drawable.graduation_pic_6,
        R.drawable.graduation_pic_7,
        R.drawable.graduation_pic_8,
        R.drawable.graduation_pic_9,
        R.drawable.graduation_pic_10,
        R.drawable.graduation_pic_11,
        R.drawable.graduation_pic_12,
        R.drawable.graduation_pic_13,
        R.drawable.graduation_pic_14,
        R.drawable.graduation_pic_15,
        R.drawable.graduation_pic_16,
        R.drawable.graduation_pic_17,
        R.drawable.mut_graduates

    )
    val imageDescription = listOf(
        R.string.pic_1,
        R.string.pic_2,
        R.string.pic_3,
        R.string.pic_4,
        R.string.pic_5,
        R.string.pic_6,
        R.string.pic_7,
        R.string.pic_8,
        R.string.pic_9,
        R.string.pic_10,
        R.string.pic_11,
        R.string.pic_12,
        R.string.pic_13,
        R.string.pic_14,
        R.string.pic_15,
        R.string.pic_16,
        R.string.pic_17,
        R.string.pic_18,
    )
    val imageDescriptionOne = listOf(
        R.string.pic_1_desc,
        R.string.pic_2_desc,
        R.string.pic_3_desc,
        R.string.pic_4_desc,
        R.string.pic_5_desc,
        R.string.pic_6_desc,
        R.string.pic_7_desc,
        R.string.pic_8_desc,
        R.string.pic_9_desc,
        R.string.pic_10_desc,
        R.string.pic_11_desc,
        R.string.pic_12_desc,
        R.string.pic_13_desc,
        R.string.pic_14_desc,
        R.string.pic_15_desc,
        R.string.pic_16_desc,
        R.string.pic_17_desc,
        R.string.pic_18_desc,
    )
        Scaffold(
            modifier = Modifier,

            topBar = {
                TopAppBar(

                    colors = topAppBarColors(
                        containerColor = Color(0xFFBD6801),
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = { Text(text = stringResource(id = R.string.top_app_bar_title),
                        color = Color(0xFF0017AF),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    ) })


            }
        ) { innerPadding ->
            Column(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
            Surface(
                shape = RectangleShape,
                tonalElevation = 2.dp,
                shadowElevation = 2.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
                    .fillMaxHeight(0.5f)
            ) {
                Image(
                    painter = painterResource(imageList[currentImageIndex]),
                    contentDescription = null
                )
            }
                //Spacer(modifier = Modifier.width(16.dp))
                Surface(
                    shape = RectangleShape,
                    tonalElevation = 2.dp,
                    shadowElevation = 2.dp,
                    modifier = Modifier
                        .padding(top=15.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        Text(
                            text = stringResource(imageDescription[currentImageIndex]),
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        )
                        Text(
                            text = stringResource(imageDescriptionOne[currentImageIndex]),
                            fontWeight = FontWeight.SemiBold,
                            fontStyle = FontStyle.Italic,
                            color = Color(0xFF021F75),
                            fontSize = 16.sp
                        )
                    }
                }
            Surface(
                shape = RectangleShape,
                tonalElevation = 2.dp,
                shadowElevation = 2.dp,
                modifier = Modifier
            )     {
                    Column(

                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 160.dp)


                    ) {
                        Row(
                            modifier = Modifier,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(onClick = {
                                currentImageIndex =
                                    (currentImageIndex - 1 + imageList.size) % imageList.size
                            })
                            {
                                Text(text = "Previous")
                            }
                            Spacer(modifier = Modifier.width(100.dp))
                            Button(onClick = {
                                currentImageIndex = (currentImageIndex + 1) % imageList.size
                            }) {
                                Text(text = "Next")
                            }
                        }
                    }
                }

        }


    }


}

@Preview(showBackground = true)
@Composable
fun AlbumBodyPreview() {

        AlbumBody()


}