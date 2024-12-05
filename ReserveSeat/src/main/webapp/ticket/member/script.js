document.getElementById("loginButton").addEventListener("click", async () => {
    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;

    if (!userId || !password) {
        alert("아이디와 비밀번호를 입력해주세요.");
        return;
    }

    try {
        const response = await fetch("/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ userId, password })
        });

        if (response.ok) {
            const result = await response.json();
            if (result.success) {
                alert("로그인 성공!");
                // 로그인 성공 시 페이지 이동 등 처리
                window.location.href = "/mypage";
            } else {
                if (result.message === "회원이 존재하지 않습니다.") {
                    alert("회원 정보가 없습니다. 회원 등록 버튼을 활성화합니다.");
                    document.getElementById("registerButton").classList.remove("hidden");
                } else {
                    alert("로그인 실패: " + result.message);
                }
            }
        } else {
            alert("서버 오류가 발생했습니다.");
        }
    } catch (error) {
        console.error("Error during login:", error);
        alert("로그인 중 오류가 발생했습니다.");
    }
});

document.getElementById("registerButton").addEventListener("click", async () => {
    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;

    if (!userId || !password) {
        alert("아이디와 비밀번호를 입력해주세요.");
        return;
    }

    try {
        const response = await fetch("/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ userId, password })
        });

        if (response.ok) {
            const result = await response.json();
            if (result.success) {
                alert("회원 등록 성공! 이제 로그인 가능합니다.");
                document.getElementById("registerButton").classList.add("hidden");
            } else {
                alert("회원 등록 실패: " + result.message);
            }
        } else {
            alert("서버 오류가 발생했습니다.");
        }
    } catch (error) {
        console.error("Error during registration:", error);
        alert("회원 등록 중 오류가 발생했습니다.");
    }
});
