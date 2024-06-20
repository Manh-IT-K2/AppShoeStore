package com.example.appshoestore.Screen


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.Model.OnBoarding
import com.example.appshoestore.ui.theme.Purple200
import com.example.appshoestore.ui.theme.f1
import com.example.appshoestore.ui.theme.f10
import com.example.appshoestore.ui.theme.f2
import com.example.appshoestore.ui.theme.f3
import com.example.appshoestore.ui.theme.f4
import com.example.appshoestore.ui.theme.f5
import com.example.appshoestore.ui.theme.f6
import com.example.appshoestore.ui.theme.f7
import com.example.appshoestore.ui.theme.f8
import com.example.appshoestore.ui.theme.f9
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(onFinished: () -> Unit) {
    val page = listOf(OnBoarding.FirstPage, OnBoarding.SecondPage, OnBoarding.ThirdPage)
    val pagerState = rememberPagerState(initialPage = 0) {
        page.size
    }
    val buttonState = remember {
        derivedStateOf {
            when (pagerState.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Start")
                else -> listOf("", "")
            }
        }
    }
    val scope = rememberCoroutineScope()
    Scaffold(modifier = Modifier.background(Color.LightGray), bottomBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 22.dp, bottom = 20.dp)
                    .background(Color.Transparent), contentAlignment = Alignment.CenterStart
            ) {
                if (buttonState.value[0].isNotEmpty()) {
                    ButtonUI(
                        text = buttonState.value[0],
                        backgroundColor = Color.Transparent,
                        textColor = Color.Gray
                    ) {
                        scope.launch {
                            if (pagerState.currentPage > 0) {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 22.dp, bottom = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                IndicatorUI(pageSize = page.size, currentPage = pagerState.currentPage)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 22.dp, bottom = 20.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                ButtonUI(
                    text = buttonState.value[1],
                    textColor = Color.White,
                    backgroundColor = Purple200
                ) {
                    scope.launch {
                        if (pagerState.currentPage < page.size - 1) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        } else {
                            onFinished()
                        }
                    }
                }
            }
        }
    }, content = {
        Column(Modifier.padding(it)) {
            HorizontalPager(state = pagerState) { index ->
                OnBoardingUI(onBoarding = page[index])
            }
        }
    })

}

@Preview
@Composable
fun ScreenPreview() {
    OnBoardingScreen {

    }
}

@Composable
fun OnBoardingUI(onBoarding: OnBoarding) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier.size(50.dp))
        Image(
            painter = painterResource(id = onBoarding.image),
            contentDescription = null,
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
                .padding(50.dp, 0.dp),
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.size(50.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = onBoarding.title,
                fontSize = 25.sp,
                fontFamily = f1,
                color = Color.Black
            )
            Text(
                text = onBoarding.titleMain,
                fontSize = 25.sp,
                fontFamily = f1,
                color = Color.Red,

                )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )
        Text(
            text = onBoarding.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontFamily = FontFamily.Serif,
            color = Color.DarkGray
        )

    }
}

@Preview
@Composable
fun OnBoardingFirstPage() {
    OnBoardingUI(onBoarding = OnBoarding.FirstPage)
}

@Preview
@Composable
fun OnBoardingSecondPage() {
    OnBoardingUI(onBoarding = OnBoarding.SecondPage)
}

@Preview
@Composable
fun OnBoardingThirdPage() {
    OnBoardingUI(onBoarding = OnBoarding.ThirdPage)
}

// indicator
@Composable
fun IndicatorUI(
    pageSize: Int,
    currentPage: Int,
    selectedColor: Color = Color.White,
    unSelectedColor: Color = Color.DarkGray
) {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) {
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .width(if (it == currentPage) 32.dp else 14.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = if (it == currentPage) selectedColor else unSelectedColor)
            )
            Spacer(modifier = Modifier.size(2.5.dp))
        }
    }
}

@Preview
@Composable
fun IndicatorFirstPage() {
    IndicatorUI(pageSize = 3, currentPage = 0)
}

@Preview
@Composable
fun IndicatorSecondPage() {
    IndicatorUI(pageSize = 3, currentPage = 1)
}

@Preview
@Composable
fun IndicatorThirdPage() {
    IndicatorUI(pageSize = 3, currentPage = 2)
}


// button
@Composable
fun ButtonUI(
    text: String = "Next",
    backgroundColor: Color = Purple200,
    textColor: Color = Color.White,
    fontSize: Int = 14,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = textColor, backgroundColor = backgroundColor
        ),
        elevation = ButtonDefaults.elevation(0.dp),
        shape = RoundedCornerShape(10.dp),
        border = null
    ) {
        Text(text = text, fontSize = fontSize.sp, fontFamily = f1)
    }
}

@Preview
@Composable
fun NextButton() {
    ButtonUI(text = "Next") {}
}

@Preview
@Composable
fun BackButton() {
    ButtonUI(
        text = "Back", backgroundColor = Color.Transparent, textColor = Color.Gray, fontSize = 13
    ) {}
}