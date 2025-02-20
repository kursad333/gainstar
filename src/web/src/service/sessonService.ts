import type {MuscleGroup} from "@/model/MuscleGroup.ts";

class SessionService {
    public getAllMuscleGroups(): Promise<MuscleGroup[]> {
        return new Promise<any>((resolve, reject) => {
            fetch('http://localhost:8080/api/power/musclegroups', {
                method: "GET",
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(res => {
                    resolve(res.json());
                })
                .catch(reject);
        });
    }
}

export const sessionService: SessionService = new SessionService();