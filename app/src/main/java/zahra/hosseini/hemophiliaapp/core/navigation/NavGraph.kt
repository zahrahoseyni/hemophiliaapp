package zahra.hosseini.hemophiliaapp.core.navigation

import PasswordSettingScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zahra.hosseini.hemophiliaapp.authentication.presentation.LoginScreen
import zahra.hosseini.hemophiliaapp.authentication.presentation.RegisterScreen
import zahra.hosseini.hemophiliaapp.main.bleeding.presentation.RegisterBleedingScreen
import zahra.hosseini.hemophiliaapp.main.doctors.presentation.DoctorsPageScreen
import zahra.hosseini.hemophiliaapp.main.home.presentation.GuidanceScreen
import zahra.hosseini.hemophiliaapp.main.injection.presentation.RegisterInjectionScreen
import zahra.hosseini.hemophiliaapp.main.injection.presentation.RegisterNotInjectionScreen
import zahra.hosseini.hemophiliaapp.main.profile.presentation.AboutUseScreen
import zahra.hosseini.hemophiliaapp.main.ui.*
import zahra.hosseini.hemophiliaapp.main.home.presentation.HomeScreen
import zahra.hosseini.hemophiliaapp.main.profile.presentation.ProfileScreen
import zahra.hosseini.hemophiliaapp.main.reminder.presentation.*
import zahra.hosseini.hemophiliaapp.main.training.presentation.TrainingScreen
import zahra.hosseini.hemophiliaapp.main.training.presentation.FirstTrainingBlogScreen
import zahra.hosseini.hemophiliaapp.main.training.presentation.SecondTrainingBlogScreen
import zahra.hosseini.hemophiliaapp.main.training.presentation.ThirdTrainingBlogScreen
import zahra.hosseini.hemophiliaapp.splashscreen.presentation.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash.path
    ) {
        addSplashScreen(navController, this)

        addLoginScreen(navController, this)

        addRegisterScreen(navController, this)

        addHomeScreen(navController, this)

        addProfileScreen(navController, this)

        addTrainingScreen(navController, this)

        addReminderScreen(navController, this)

        addRegisterBleedingScreen(navController, this)

        addRegisterInjectionScreen(navController, this)

        addRegisterNotInjectionScreen(navController, this)

        addDoctorsPageScreen(navController, this)

        addFirstTrainingBlogScreen(navController, this)

        addSecondTrainingBlogScreen(navController, this)

        addThirdTrainingBlogScreen(navController, this)

        addRegisterNotInjectionScreen(navController, this)

        addRegisterNotInjectionScreen(navController, this)

        addAboutUsScreen(navController, this)

        addPasswordSettingScreen(navController, this)

        addGuidanceScreen(navController, this)

        addMedicineReminderScreen(navController, this)

        addDoctorAppointmentReminderScreen(navController, this)

        addExerciseReminderScreen(navController, this)
    }
}

private fun addLoginScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Login.path) {
        LoginScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            },
            navigateToRegister = {
                navController.navigate(NavRoute.Register.path)
            }
        )
    }
}

private fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Splash.path) {
        SplashScreen(
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            },
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Home.path) {
        HomeScreen(
            navigateToRegisterBleeding = {
                navController.navigate(NavRoute.RegisterBleeding.path)
            },
            navigateToRegisterInjection = {
                navController.navigate(NavRoute.RegisterInjection.path)
            },
            navigateToRegisterNotInjection = {
                navController.navigate(NavRoute.RegisterNotInjection.path)
            },
            navigateToDoctors = {
                navController.navigate(NavRoute.DoctorsPage.path)
            }
        )
    }
}

private fun addProfileScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Profile.path) {
        ProfileScreen(
            navigateToAboutUs = {
                navController.navigate(NavRoute.AboutUs.path)
            },
            navigateToLogin = {
                navController.navigate(NavRoute.Login.path)
            },
            navigateToPasswordScreen = {
                navController.navigate(NavRoute.PasswordSetting.path)
            }
        )
    }
}


private fun addRegisterScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Register.path) {
        RegisterScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addTrainingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Training.path) {
        TrainingScreen(
            navigateToFirstTrainingBlog = {
                navController.navigate(NavRoute.FirstTrainingBlog.path)
            },
            navigateToSecondTrainingBlog = {
                navController.navigate(NavRoute.SecondTrainingBlog.path)
            },
            navigateToThirdTrainingBlog = {
                navController.navigate(NavRoute.ThirdTrainingBlog.path)
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun addReminderScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Reminder.path) {
        ReminderScreen(
            navigateToMedicineReminder = {
                navController.navigate(NavRoute.MedicineReminder.path)
            },
            navigateToDoctorAppointmentReminder = {
                navController.navigate(NavRoute.DoctorAppointmentReminder.path)
            },
            navigateToExerciseReminder = {
                navController.navigate(NavRoute.ExerciseReminder.path)
            }
        )
    }
}

private fun addRegisterBleedingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.RegisterBleeding.path) {
        RegisterBleedingScreen(
            navigateToHome =
            { navController.navigate(NavRoute.Home.path) }
        )
    }
}

private fun addRegisterInjectionScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.RegisterInjection.path) {
        RegisterInjectionScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

private fun addRegisterNotInjectionScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.RegisterNotInjection.path) {
        RegisterNotInjectionScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun addDoctorsPageScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.DoctorsPage.path) {
        DoctorsPageScreen(
            navigateToHome = {
                navController.navigate(NavRoute.Home.path)
            }
        )
    }
}


private fun addFirstTrainingBlogScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.FirstTrainingBlog.path) {
        FirstTrainingBlogScreen()
    }
}

private fun addSecondTrainingBlogScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.SecondTrainingBlog.path) {
        SecondTrainingBlogScreen()
    }
}

private fun addThirdTrainingBlogScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.ThirdTrainingBlog.path) {
        ThirdTrainingBlogScreen()
    }
}

private fun addAboutUsScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.AboutUs.path) {
        AboutUseScreen()
    }
}

private fun addPasswordSettingScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.PasswordSetting.path) {
        PasswordSettingScreen(navigateToProfileScreen = {
            navController.navigate(NavRoute.Profile.path)
        })
    }
}

private fun addGuidanceScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.Guidance.path) {
        GuidanceScreen()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun addMedicineReminderScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.MedicineReminder.path) {
        MedicineReminderScreen(navigateToReminder = {
            navController.navigate(NavRoute.Reminder.path)
        })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun addDoctorAppointmentReminderScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.DoctorAppointmentReminder.path) {
        DoctorAppointmentReminderScreen(navigateToReminder = {
            navController.navigate(NavRoute.Reminder.path)
        })
    }
}

private fun addExerciseReminderScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = NavRoute.ExerciseReminder.path) {
        ExerciseReminderScreen(navigateToReminder = {
            navController.navigate(NavRoute.Reminder.path)
        })
    }
}